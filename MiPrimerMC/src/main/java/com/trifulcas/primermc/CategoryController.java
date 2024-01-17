package com.trifulcas.primermc;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="/cat")
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@GetMapping("/test")
	public String test() {
		return "Todo OK";
	}
	
	@GetMapping("/testdata")
	public Optional<Category> testData() {
		return categoryRepository.findById(1);
	}
	
	@GetMapping("/all")
	public Iterable<Category> getAllCats() {
		return categoryRepository.findAll();
	}
	
	@GetMapping("/get/{id}")
	public Optional<Category> getCat(@PathVariable int id) {
		return categoryRepository.findById(id);
	}
	
	@GetMapping("/add")
	public @ResponseBody String addNewCat(@RequestParam(value = "name", defaultValue = "Nueva") String name) {

		Category cat = new Category(name);
		categoryRepository.save(cat);
		return "Saved "+cat.getCategoryId();
	}
}
