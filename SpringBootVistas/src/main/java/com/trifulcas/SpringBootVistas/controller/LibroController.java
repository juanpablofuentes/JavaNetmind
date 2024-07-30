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
import org.springframework.web.bind.annotation.RequestParam;

import com.trifulcas.SpringBootVistas.model.Autor;
import com.trifulcas.SpringBootVistas.model.Genero;
import com.trifulcas.SpringBootVistas.model.Libro;
import com.trifulcas.SpringBootVistas.repository.AutorRepository;
import com.trifulcas.SpringBootVistas.repository.GeneroRepository;
import com.trifulcas.SpringBootVistas.repository.LibroRepository;

// La anotación nos indica que es un controlador normal, que requerirá una vista
@Controller
// Nos indica la ruta de entrada general a este controlador
@RequestMapping("/libro")
public class LibroController {

	// Necesitamos acceder a los datos por lo tanto creamos el repositorio
	// el autowired nos hace inyección de dependencia automática
	@Autowired
	LibroRepository libroRepository;
	@Autowired
	GeneroRepository generoRepository;
	@Autowired
	AutorRepository autorRepository;

	// Aquí especificamos que accedemos vía get
	@GetMapping("")
	// Pongo el parámetro Model que nos permita pasar datos a la vista
	public String getLibros(Model model) {
		try {
			// Obtengo los datos como en la API rest
			List<Libro> libros = libroRepository.findAll();
			// Paso la información a la vista vía model
			// La vista tendrá una variable 'autores' con la lista de autores
			model.addAttribute("libros", libros);
			// Le digo que me cargue la vista 'autores' la buscará en templates
			return "libros";
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return "error";
		}
	}

	// Mapeo que me pasen un parámetro id
	@GetMapping("/{id}")
	// Tengo el parámetro id que me pasan y el model para pasar datos a la vista
	public String getLibro(Model model, @PathVariable Integer id) {
		try {
			// Recupero el autor
			Libro libro = libroRepository.findById(id).orElse(null);
			if (libro != null) {
				// Lo paso a la vista
				model.addAttribute("libro", libro);
				List<Autor> autores=autorRepository.findAll();
				model.addAttribute("autores", autores);

				// Devuelvo la vista
				return "libro";
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
	public String addAutor(Libro libro, Model model) {
		List<Genero> generos=generoRepository.findAll();
		model.addAttribute("generos", generos);
		// Simplemente mostramos la vista
		return "addlibro";
	}

	// Cuando desde la vista nos añaden el autor entramos por 'POST'
	@PostMapping("/add")
	// Con @Validated recuperamos los datos y los metemos dentro de una entidad,
	// spring lo hace solo
	// En result se guardan los datos de la validación, es decir ¿Lo que nos mandan
	// son datos válidos? Si es que sí, no dará error, en caso contrario
	// en result tenemos la lista de errores
	public String addAutorDatos(@Validated Libro libro, BindingResult result) {
		System.out.println(libro);
		System.out.println(result);
		try {
			// Si hay algún error volvemos a mostrar la vista y además
			// fields.error tendrá la información de los errores
			if (result.hasErrors()) {
				return "addautor";
			}
			// Si no hay ningún error guardamos el autor
			libroRepository.save(libro);
			// Y en vez de devolver una vista, redirigimos al índice
			return "redirect:/libro";
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return "error";
		}
	}

	@PostMapping("/addautor")
		public String addAutorLibro(@RequestParam Integer idautor,@RequestParam Integer idlibro) {
		System.out.println(idautor);
		System.out.println(idlibro);
		try {
			Autor autor=autorRepository.findById(idautor).orElse(null);
			Libro libro=libroRepository.findById(idlibro).orElse(null);
			if (autor!=null && libro !=null) {
				libro.getAutores().add(autor);
				libroRepository.save(libro);
			}
			return "redirect:/libro";
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return "error";
		}
	}
	@GetMapping("/edit/{id}")
	// Usamos el model porque tenemos que recuperar al autor
	public String addLibro(@PathVariable Integer id, Model model) {
		try {
			// Primero, buscamos el autor que se quiere editar
			Libro libro = libroRepository.findById(id).orElse(null);
			if (libro != null) {
				List<Genero> generos=generoRepository.findAll();
				model.addAttribute("generos", generos);
	
				// Añadimos el autor al modelo
				model.addAttribute("libro", libro);
				return "updatelibro";
			} else {
				return "error";
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return "error";
		}

	}
	
	@PostMapping("/update/{id}")
	public String updateLibro(@PathVariable Integer id, @Validated Libro libro, BindingResult result) {
		System.out.println(libro);
		try {
			if (result.hasErrors()) {
				return "updateautor";
			}
			libroRepository.save(libro);
			return "redirect:/libro";
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return "error";
		}
	}
	
	@GetMapping("/delete/{id}")
	// Usamos el model porque tenemos que recuperar al autor
	public String deleteLibro(@PathVariable Integer id, Model model) {
		try {
			// Primero, buscamos el autor que se quiere editar
			// Añadimos el autor al modelo
			Libro libro = libroRepository.findById(id).orElse(null);
			if (libro!=null && libro.getAutores().size()==0) {
				libroRepository.deleteById(id);
			}
			
			return "redirect:/libro";

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return "error";
		}

	}
	@GetMapping("/delete/{id}/autor/{idautor}")
	// Usamos el model porque tenemos que recuperar al autor
	public String deleteLibroAutor(@PathVariable Integer id, @PathVariable Integer idautor) {
		try {
			Autor autor=autorRepository.findById(idautor).orElse(null);
			Libro libro=libroRepository.findById(id).orElse(null);
			if (libro!=null && autor!=null) {
				libro.getAutores().remove(autor);
				libroRepository.save(libro);
			}
			return "redirect:/libro";

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return "error";
		}

	}
}
