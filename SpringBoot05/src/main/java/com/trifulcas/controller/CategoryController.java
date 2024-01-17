package com.trifulcas.controller;

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
import com.trifulcas.repository.CategoryRepository;

@Controller
@RequestMapping(path = "/cat")
public class CategoryController {
	@Autowired
	private CategoryRepository categoryRepository;

	@GetMapping("/index")
	public String showUserList(Model model) {
		model.addAttribute("categories", categoryRepository.findAll());
		return "index";
	}

	@GetMapping("/add")
	public String showAdd(Category cat) {
		return "add";
	}

	@PostMapping("/addcat")
	public String addUser(@Validated Category cat, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add";
		}

		categoryRepository.save(cat);
		return "redirect:/cat/index";
	}
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
	    Category cat = categoryRepository.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid cat Id:" + id));
	    
	    model.addAttribute("category", cat);
	    return "update";
	}
	@PostMapping("/update/{id}")
	public String updateCat(@PathVariable("id") int id, @Validated Category cat, 
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	        cat.setCategoryId(id);
	        return "update";
	    }
	        
	    categoryRepository.save(cat);
	    return "redirect:/cat/index";
	}
	@GetMapping("/delete/{id}")
	public String deleteCat(@PathVariable("id") int id, Model model) {
	    Category cat = categoryRepository.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Id de categoría no válido:" + id));
	    categoryRepository.delete(cat);
	    return "redirect:/cat/index";
	}
}
