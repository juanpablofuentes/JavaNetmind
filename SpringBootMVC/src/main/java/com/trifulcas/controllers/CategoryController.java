package com.trifulcas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trifulcas.models.Category;
import com.trifulcas.repositories.CategoryRepository;

@Controller
@RequestMapping(path = "/cat")
public class CategoryController {

	@Autowired
	CategoryRepository categoryRepository;

	@GetMapping("/index")
	public String getAll(Model model) {
		model.addAttribute("categories", categoryRepository.findAll());

		return "index";
	}

	@GetMapping("/add")
	public String addCat(Category category) {
		return "add";
	}

	@PostMapping("/addcat")
	public String addCategory(@Validated Category category, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add";
		}
		categoryRepository.save(category);
		return "redirect:/cat/index";
	}

	@GetMapping("/edit/{id}")
	public String editCategory(@PathVariable("id") int id, Model model) {
		Category category = categoryRepository.findById(id).get();
		model.addAttribute("category", category);
		return "update";
	}

	@PostMapping("/updatecat/{id}")
	public String updateCategory(@PathVariable("id") int id, @Validated Category category, BindingResult result,
			Model model) {
		category.setCategoryId(id);
		if (result.hasErrors()) {
			return "update";
		}
		categoryRepository.save(category);
		return "redirect:/cat/index";

	}
	@GetMapping("/delete/{id}")
	public String deleteCat(@PathVariable("id") int id) {
		categoryRepository.deleteById(id);
		return "redirect:/cat/index";
	}
}
