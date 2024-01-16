package com.trifulcas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@GetMapping("/saludo")
	public String saludo(@RequestParam(name = "nombre", required = false, defaultValue = "Ana") String nombre,
			Model model) {
		model.addAttribute("nombre", nombre);
		return "saludo";
	}
}
