package com.trifulcas.SpringBootVistas.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trifulcas.SpringBootVistas.model.Autor;
import com.trifulcas.SpringBootVistas.model.Libro;
import com.trifulcas.SpringBootVistas.repository.AutorRepository;


@RestController
@RequestMapping("/api/autor")
public class AutorRestController {

	@Autowired
	AutorRepository autorRepository;

	@GetMapping("")
	public List<Autor> getAll() {
		try {
			return autorRepository.findAll();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	// Poner los valores en la URL, no parámetros nombrados
	@GetMapping("/{id}")
	public ResponseEntity<Autor> getById(@PathVariable int id) {
		System.out.println(id);

		try {
			Autor cat = autorRepository.findById(id).orElse(null);
			if (cat != null) {
				return new ResponseEntity<>(cat, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

	// Poner los valores en la URL, no parámetros nombrados
	@GetMapping("/{id}/libros")
	public Set<Libro> getLibrosByIdAutor(@PathVariable int id) {
		System.out.println(id);

		try {
			Autor cat = autorRepository.findById(id).orElse(null);
			if (cat != null) {
				return cat.getLibros();
			} else {
				return null;
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	// Poner los valores en la URL, no parámetros nombrados
	@GetMapping("/titulo/{cadena}")
	public List<Autor> getAutoresByTitulo(@PathVariable String cadena) {
		System.out.println(cadena);

		try {
			return autorRepository.findByLibrosTituloContaining(cadena);
			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@PostMapping("")
	public Autor add(@RequestBody Autor cat) {
		System.out.println(cat);
		try {
			if (cat.getIdautor() == 0 && cat.getNombre() != null) {
				return autorRepository.save(cat);
			} else {
				return null;
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@PutMapping("/{id}")
	public Autor put(@RequestBody Autor cat, @PathVariable int id) {
		System.out.println(cat);
		System.out.println(id);
		try {
			if (cat.getIdautor() == id) {
				return autorRepository.save(cat);
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
			autorRepository.deleteById(id);
			return id;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return 0;
		}
	}
}
