package com.trifulcas.controller;

import org.springframework.beans.BeanUtils;
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
import com.trifulcas.repository.CategoryRepository;

@RestController
@RequestMapping(path = "/api")
public class MainController {
	@Autowired
	private CategoryRepository categoryRepository;

	@GetMapping("/all")
	public @ResponseBody Iterable<Category> getAllCategories() {
		return categoryRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Category getById(@PathVariable int id) {
		return categoryRepository.findById(id).get();
	}
	
	@PostMapping("/add")
	public Category add(@RequestBody Category cat) {
		return categoryRepository.save(cat);
	}
	@PutMapping("/update/{id}")
	public Category update(@RequestBody Category cat,@PathVariable int id) {
		return categoryRepository.findById(id).map(oldCategory->
		{
			BeanUtils.copyProperties(cat,oldCategory);
			return categoryRepository.save(oldCategory);
		}).orElseGet(()->{
			cat.setCategoryId(id);
			return categoryRepository.save(cat);
		});
	}
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable int id) {
		categoryRepository.deleteById(id);
	}
	
}
