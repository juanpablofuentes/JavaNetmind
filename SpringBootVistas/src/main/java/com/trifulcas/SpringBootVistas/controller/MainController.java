package com.trifulcas.SpringBootVistas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.trifulcas.SpringBootVistas.repository.GeneroRepository;

@Controller
public class MainController {

	@Autowired
	GeneroRepository generoRepository;
	
	@GetMapping("/")
	public String index(Model model) {
		// Para pasar datos a la vista usamos model
		
		model.addAttribute("nombre", "Pepito pérez");
		
		// Lo que devolvemos aquí es el nombre de la vista
		// Spring boot automáticamente buscará una página index.html
		// En la carpeta resources/templates
		return "index";
	}

}
