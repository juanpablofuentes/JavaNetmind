package com.trifulcas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.trifulcas.models.Category;
import com.trifulcas.repositories.CategoryRepository;

@RestController
@RequestMapping(path = "/api")
public class CategoryController {

	@Autowired
	CategoryRepository categoryRepository;

	@GetMapping("/category")
	public @ResponseBody Iterable<Category> getAll() {
		return categoryRepository.findAll();
	}

	@GetMapping("/category/{id}")
	public Category getById(@PathVariable int id) {
		try {
			return categoryRepository.findById(id).get();
		} catch (Exception ex) {
			return new Category("Categoría no encontrada");
		}
	}
	
	@PostMapping("/category")
	public Category add(@RequestBody Category category) {
		return categoryRepository.save(category);
	}

	@PutMapping("/category/{id}")
	public Category update(@RequestBody Category category,
			@PathVariable int id) {
		try {
			Category old=categoryRepository.findById(id).get();
			old.setName(category.getName());
			// O BeanUtils.copyProperties(category,old);
			return categoryRepository.save(old);
		} catch (Exception ex) {
			return new Category("Categoría no encontrada");
		}
	}
	
	@DeleteMapping("/category/{id}")
	public void delete(@PathVariable int id) {
		categoryRepository.deleteById(id);
	}
	
}
