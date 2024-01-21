package com.trifulcas.controllers;

import java.util.ArrayList;
import java.util.List;

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

import com.trifulcas.models.Category;
import com.trifulcas.models.City;
import com.trifulcas.repositories.CategoryRepository;

@RestController
@RequestMapping("/api")
public class CategoryController {
	@Autowired
	CategoryRepository categoryRepository;

	@GetMapping("/category")
	public ResponseEntity<List<Category>> getAll(@RequestParam(required = false) String name) {
		List<Category> res = new ArrayList<>();
		if (name == null) {
			categoryRepository.findAll().forEach(res::add);
		} else {
			categoryRepository.findByNameContaining(name).forEach(res::add);
		}
		if (res.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@GetMapping("film/{id}/category")
	public ResponseEntity<List<Category>> getAllByFilm(@PathVariable("id") int id) {
		List<Category> res = new ArrayList<>();
		categoryRepository.findCategoryByFilmsFilmId(id).forEach(res::add);
		if (res.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@GetMapping("/category/{id}")
	public ResponseEntity<Category> getCategory(@PathVariable("id") int id) {
		Category category = categoryRepository.findById(id)
				// .orElseThrow(()->new ResourceNotFoundException("Category not found"));
				.orElse(null);
		if (category == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(category, HttpStatus.OK);
		}
	}

	@PostMapping("/category")
	public ResponseEntity<Category> addCategory(@RequestBody Category category) {
		Category temp = categoryRepository.save(new Category(category.getName()));
		return new ResponseEntity<>(temp, HttpStatus.CREATED);
	}

	@PutMapping("/category/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable("id") int id, @RequestBody Category category) {
		Category temp = categoryRepository.findById(id).orElse(null);
		if (temp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			temp.setName(category.getName());
			return new ResponseEntity<>(categoryRepository.save(temp), HttpStatus.OK);

		}
	}

	@DeleteMapping("/category/{id}")
	public ResponseEntity<HttpStatus> deleteCategory(@PathVariable("id") int id) {
		categoryRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
