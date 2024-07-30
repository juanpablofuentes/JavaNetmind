package com.trifulcas.SpringBootVistas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trifulcas.SpringBootVistas.model.Genero;
import com.trifulcas.SpringBootVistas.repository.GeneroRepository;

@Controller
@RequestMapping("/genero")
public class GeneroController {

	@Autowired
	GeneroRepository generoRepository;

	// La primera vez que estamos haciendo un MVC como dios manda
	@GetMapping("/{id}")
	public String getGenero(Model model, @PathVariable int id) {
		// Voy al modelo para obtener los datos del genero
		Genero genero = generoRepository.findById(id).orElse(null);
		// Una vez tengo esos datos los envío a la vista vía model
		model.addAttribute("genero", genero);

		// Lo que devolvemos aquí es el nombre de la vista
		// Spring boot automáticamente buscará una página index.html
		// En la carpeta resources/templates
		return "genero";
	}

	// La primera vez que estamos haciendo un MVC como dios manda
	@GetMapping("")
	public String getGeneros(Model model) {
		// Voy al modelo para obtener los datos del genero
		List<Genero> generos = generoRepository.findAll();
		// Una vez tengo esos datos los envío a la vista vía model
		model.addAttribute("generos", generos);

		// Lo que devolvemos aquí es el nombre de la vista
		// Spring boot automáticamente buscará una página index.html
		// En la carpeta resources/templates
		return "generos";
	}

	// El primer mapeo es con get para simplemente mostrar la vista
	@GetMapping("/add")
	// Pasamos como parámetro el autor para que la vista lo pueda tener disponible
	public String addGenero(Genero genero) {
		// Simplemente mostramos la vista
		return "addgenero";
	}

	// Cuando desde la vista nos añaden el autor entramos por 'POST'
		@PostMapping("/add")
		// Con @Validated recuperamos los datos y los metemos dentro de una entidad,
		// spring lo hace solo
		// En result se guardan los datos de la validación, es decir ¿Lo que nos mandan
		// son datos válidos? Si es que sí, no dará error, en caso contrario
		// en result tenemos la lista de errores
		public String addGeneroDatos(@Validated Genero genero, BindingResult result) {
			System.out.println(genero);
			System.out.println(result);
			try {
				// Si hay algún error volvemos a mostrar la vista y además
				// fields.error tendrá la información de los errores
				if (result.hasErrors()) {
					return "addautor";
				}
				// Si no hay ningún error guardamos el autor
				generoRepository.save(genero);
				// Y en vez de devolver una vista, redirigimos al índice
				return "redirect:/genero";
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
				return "error";
			}
		}
		
		@GetMapping("/edit/{id}")
		// Usamos el model porque tenemos que recuperar al autor
		public String editGenero(@PathVariable Integer id, Model model) {
			try {
				// Primero, buscamos el autor que se quiere editar
				Genero genero= generoRepository.findById(id).orElse(null);
				if (genero != null) {
					// Añadimos el autor al modelo
					model.addAttribute("genero", genero);
					return "updategenero";
				} else {
					return "error";
				}
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
				return "error";
			}

		}
		@PostMapping("/update/{id}")
		public String updateGenero(@PathVariable Integer id, @Validated Genero genero, BindingResult result) {
			System.out.println(genero);
			try {
				if (result.hasErrors()) {
					return "updategenero";
				}
				generoRepository.save(genero);
				return "redirect:/genero";
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
				return "error";
			}
		}
		@GetMapping("/delete/{id}")
		// Usamos el model porque tenemos que recuperar al autor
		public String deleteGenero(@PathVariable Integer id, Model model) {
			try {
				// Primero, buscamos el autor que se quiere editar
				Genero genero= generoRepository.findById(id).orElse(null);
				if (genero != null) {
					// Añadimos el autor al modelo
					model.addAttribute("genero", genero);
					return "deletegenero";
				} else {
					return "error";
				}
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
				return "error";
			}

		}
		@PostMapping("/delete/{id}")
		public String destroyGenero(@PathVariable Integer id, @Validated Genero genero, BindingResult result) {
			System.out.println(genero);
			try {
				
				generoRepository.delete(genero);
				return "redirect:/genero";
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
				return "error";
			}
		}
}
