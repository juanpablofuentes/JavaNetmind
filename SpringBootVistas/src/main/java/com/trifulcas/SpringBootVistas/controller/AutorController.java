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

import com.trifulcas.SpringBootVistas.model.Autor;
import com.trifulcas.SpringBootVistas.repository.AutorRepository;

// La anotación nos indica que es un controlador normal, que requerirá una vista
@Controller
// Nos indica la ruta de entrada general a este controlador
@RequestMapping("/autor")
public class AutorController {

	// Necesitamos acceder a los datos por lo tanto creamos el repositorio
	// el autowired nos hace inyección de dependencia automática
	@Autowired
	AutorRepository autorRepository;

	// Aquí especificamos que accedemos vía get
	@GetMapping("")
	// Pongo el parámetro Model que nos permita pasar datos a la vista
	public String getAutores(Model model) {
		try {
			// Obtengo los datos como en la API rest
			List<Autor> autores = autorRepository.findAll();
			// Paso la información a la vista vía model
			// La vista tendrá una variable 'autores' con la lista de autores
			model.addAttribute("autores", autores);
			// Le digo que me cargue la vista 'autores' la buscará en templates
			return "autores";
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return "error";
		}
	}

	// Mapeo que me pasen un parámetro id
	@GetMapping("/{id}")
	// Tengo el parámetro id que me pasan y el model para pasar datos a la vista
	public String getAutor(Model model, @PathVariable Integer id) {
		try {
			// Recupero el autor
			Autor autor = autorRepository.findById(id).orElse(null);
			if (autor != null) {
				// Lo paso a la vista
				model.addAttribute("autor", autor);
				// Devuelvo la vista
				return "autor";
			} else {
				// Me he creado una vista para mostrar un error
				return "error";
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return "error";
		}
	}

	// El primer mapeo es con get para simplemente mostrar la vista
	@GetMapping("/add")
	// Pasamos como parámetro el autor para que la vista lo pueda tener disponible
	public String addAutor(Autor autor) {
		// Simplemente mostramos la vista
		return "addautor";
	}

	// Cuando desde la vista nos añaden el autor entramos por 'POST'
	@PostMapping("/add")
	// Con @Validated recuperamos los datos y los metemos dentro de una entidad,
	// spring lo hace solo
	// En result se guardan los datos de la validación, es decir ¿Lo que nos mandan
	// son datos válidos? Si es que sí, no dará error, en caso contrario
	// en result tenemos la lista de errores
	public String addAutorDatos(@Validated Autor autor, BindingResult result) {
		System.out.println(autor);
		System.out.println(result);
		try {
			// Si hay algún error volvemos a mostrar la vista y además
			// fields.error tendrá la información de los errores
			if (result.hasErrors()) {
				return "addautor";
			}
			// Si no hay ningún error guardamos el autor
			autorRepository.save(autor);
			// Y en vez de devolver una vista, redirigimos al índice
			return "redirect:/autor";
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return "error";
		}
	}

	@GetMapping("/edit/{id}")
	// Usamos el model porque tenemos que recuperar al autor
	public String addAutor(@PathVariable Integer id, Model model) {
		try {
			// Primero, buscamos el autor que se quiere editar
			Autor autor = autorRepository.findById(id).orElse(null);
			if (autor != null) {
				// Añadimos el autor al modelo
				model.addAttribute("autor", autor);
				return "updateautor";
			} else {
				return "error";
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return "error";
		}

	}

	@PostMapping("/update/{id}")
	public String updateAutor(@PathVariable Integer id, @Validated Autor autor, BindingResult result) {
		System.out.println(autor);
		try {
			if (result.hasErrors()) {
				return "updateautor";
			}
			autorRepository.save(autor);
			return "redirect:/autor";
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return "error";
		}
	}

	@GetMapping("/delete/{id}")
	// Usamos el model porque tenemos que recuperar al autor
	public String deleteAutor(@PathVariable Integer id, Model model) {
		try {
			// Primero, buscamos el autor que se quiere editar
			// Añadimos el autor al modelo
			autorRepository.deleteById(id);
			return "redirect:/autor";

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return "error";
		}

	}
}
