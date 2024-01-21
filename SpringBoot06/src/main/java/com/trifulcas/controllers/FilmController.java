package com.trifulcas.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trifulcas.models.Film;
import com.trifulcas.models.Category;
import com.trifulcas.models.City;
import com.trifulcas.repositories.CategoryRepository;
import com.trifulcas.repositories.FilmRepository;

@RestController
@RequestMapping("/api")
public class FilmController {
	@Autowired
	FilmRepository filmRepository;
	@Autowired
	CategoryRepository categoryRepository;

	@GetMapping("/film")
	public ResponseEntity<List<Film>> getAll(@RequestParam(required = false) String text) {
		List<Film> res = new ArrayList<>();
		if (text == null) {
			filmRepository.findAll().forEach(res::add);
		} else {
			filmRepository.findByTitleContainingOrDescriptionContaining(text, text).forEach(res::add);
		}
		if (res.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@GetMapping("category/{id}/film")
	public ResponseEntity<List<Film>> getAllByFilm(@PathVariable("id") int id) {
		List<Film> res = new ArrayList<>();
		filmRepository.findFilmByCategoriesCategoryId(id).forEach(res::add);
		if (res.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@GetMapping("/film/{id}")
	public ResponseEntity<Film> getFilm(@PathVariable("id") int id) {
		Film film = filmRepository.findById(id)
				// .orElseThrow(()->new ResourceNotFoundException("Film not found"));
				.orElse(null);
		if (film == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(film, HttpStatus.OK);
		}
	}

	@PostMapping("/film")
	public ResponseEntity<Film> addFilm(@RequestBody Film film) {
		Film temp = new Film();
		BeanUtils.copyProperties(film, temp);
		film.setFilmId(0);
		return new ResponseEntity<>(filmRepository.save(temp), HttpStatus.CREATED);
	}
	@PostMapping("/film/{idfilm}/category/{idcategory}")
	public ResponseEntity<Film> addFilmCategory(@PathVariable("idfilm") int idfilm,@PathVariable("idcategory") int idcategory) {
		Film film=filmRepository.findById(idfilm).orElse(null);
		Category category = categoryRepository.findById(idcategory).orElse(null);
		if (film==null || category==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		film.getCategories().add(category);
		return new ResponseEntity<>(filmRepository.save(film), HttpStatus.CREATED);
	}
	@PutMapping("/film/{id}")
	public ResponseEntity<Film> updateFilm(@PathVariable("id") int id, @RequestBody Film film) {
		Film temp = filmRepository.findById(id).orElse(null);
		if (temp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			BeanUtils.copyProperties(film, temp);
			return new ResponseEntity<>(filmRepository.save(temp), HttpStatus.OK);

		}
	}

	@DeleteMapping("/film/{id}")
	public ResponseEntity<HttpStatus> deleteFilm(@PathVariable("id") int id) {
		filmRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@DeleteMapping("/film/{idfilm}/category/{idcategory}")
	public ResponseEntity<Film> deleteFilmCategory(@PathVariable("idfilm") int idfilm,@PathVariable("idcategory") int idcategory) {
		Film film=filmRepository.findById(idfilm).orElse(null);
		System.out.println(film);
			Category category = categoryRepository.findById(idcategory).orElse(null);
		film.getCategories().remove(category);
			System.out.println(film);
			System.out.println(category);
		if (film==null || category==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(filmRepository.save(film), HttpStatus.CREATED);
	}
}
