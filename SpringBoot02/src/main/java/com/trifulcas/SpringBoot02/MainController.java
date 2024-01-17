package com.trifulcas.SpringBoot02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/test")
public class MainController {
	@Autowired
	private CategoryRepository categoryRepository;

	@GetMapping("/add")
	public @ResponseBody String addNewUser(@RequestParam(value = "name", defaultValue = "Nueva") String name) {

		Category cat = new Category(name);
		categoryRepository.save(cat);
		return "Saved "+cat.getCategoryId();
	}

	@GetMapping("/all")
	public @ResponseBody Iterable<Category> getAllCategories() {
		//System.out.println(categoryRepository.findAll());
		return categoryRepository.findAll();
	}

	
}
