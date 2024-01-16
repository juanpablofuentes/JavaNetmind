package com.trifulcas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.trifulcas.SpringBoot04.CategoryRepository;
import com.trifulcas.models.Category;

@RestController
@RequestMapping(path = "/api")
public class MainController {
	@Autowired
	private CategoryRepository categoryRepository;

	

	@GetMapping("/all")
	public @ResponseBody Iterable<Category> getAllCategories() {
		System.out.println(categoryRepository.findAll());
		return categoryRepository.findAll();
	}

	
}
