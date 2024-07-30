package com.trifulcas.SpringBootVistas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trifulcas.SpringBootVistas.model.Autor;
import com.trifulcas.SpringBootVistas.model.Libro;
import com.trifulcas.SpringBootVistas.repository.AutorRepository;
import com.trifulcas.SpringBootVistas.repository.LibroRepository;


@RestController
@RequestMapping("/api/libro")
public class LibroRestController {

	@Autowired
	LibroRepository libroRepository;
	@Autowired
	AutorRepository autorRepository;
	private int pageSize = 5;

	@GetMapping("")
	public List<Libro> getAll(@RequestParam(required = false) Integer pagina) {
		try {
			if (pagina == null) {
				return libroRepository.findAll();
			} else {
				return libroRepository.findAll(PageRequest.of(pagina, pageSize)).getContent();
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@GetMapping("/proceso")
	public String procesarlibros() {
		try {
			System.out.println("Esto es un ejemplo sencillo de un proceso");
			// Imaginemos que yo quiero obtener una cadena con la primera letra
			// de cada título
			// Y para no bloquear la base de datos pidiendo todos los libros los hago por
			// páginas
			int pagina = 0;
			String res = "";
			List<Libro> libros = libroRepository.findAll(PageRequest.of(pagina, pageSize)).getContent();
			while (libros.size() > 0) {
				for (Libro libro : libros) {
					res += libro.getTitulo().substring(0, 1);
				}
				res+="#";
				pagina++;
				libros = libroRepository.findAll(PageRequest.of(pagina, pageSize)).getContent();
			}

			return res;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@GetMapping("/autor/{id}")
	public List<Libro> getByIdAutor(@PathVariable int id) {
		System.out.println(id);

		try {
			return libroRepository.findByAutoresIdautor(id);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@GetMapping("/titulo/{cadena}")
	public List<Libro> getByTitle(@PathVariable String cadena) {
		System.out.println(cadena);

		try {
			return libroRepository.findByTituloContaining(cadena);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	// Poner los valores en la URL, no parámetros nombrados
	@GetMapping("/{id}")
	public ResponseEntity<Libro> getById(@PathVariable int id) {
		System.out.println(id);

		try {
			Libro cat = libroRepository.findById(id).orElse(null);
			if (cat != null) {
				return new ResponseEntity<>(cat, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@PostMapping("")
	public Libro add(@RequestBody Libro cat) {
		System.out.println(cat);
		try {
			if (cat.getIdlibro() == 0 && cat.getTitulo() != null) {
				return libroRepository.save(cat);
			} else {
				return null;
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@PutMapping("/{id}")
	public Libro put(@RequestBody Libro cat, @PathVariable int id) {
		System.out.println(cat);
		System.out.println(id);
		try {
			if (cat.getIdlibro() == id) {
				return libroRepository.save(cat);
			} else {
				return null;
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@DeleteMapping("/{id}")
	public int delete(@PathVariable int id) {
		try {
			System.out.println(id);
			libroRepository.deleteById(id);
			return id;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return 0;
		}
	}

	// Gestión de libros y autores
	@PostMapping("{idlibro}/autor/{idautor}")
	public Libro addLibroAutor(@PathVariable int idlibro, @PathVariable int idautor) {
		System.out.println(idlibro);
		System.out.println(idautor);
		try {
			Libro libro = libroRepository.findById(idlibro).orElse(null);
			Autor autor = autorRepository.findById(idautor).orElse(null);
			if (libro != null && autor != null) {
				libro.getAutores().add(autor);
				return libroRepository.save(libro);
			} else {
				return null;
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	// Gestión de libros y autores
	@DeleteMapping("{idlibro}/autor/{idautor}")
	public Libro deleteLibroAutor(@PathVariable int idlibro, @PathVariable int idautor) {
		System.out.println(idlibro);
		System.out.println(idautor);
		try {
			Libro libro = libroRepository.findById(idlibro).orElse(null);
			Autor autor = autorRepository.findById(idautor).orElse(null);
			if (libro != null && autor != null) {
				libro.getAutores().remove(autor);
				return libroRepository.save(libro);
			} else {
				return null;
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
}
