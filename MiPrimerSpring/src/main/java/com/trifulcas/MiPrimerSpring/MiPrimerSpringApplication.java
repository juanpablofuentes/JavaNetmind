package com.trifulcas.MiPrimerSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MiPrimerSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiPrimerSpringApplication.class, args);
	}
	@GetMapping("/hola")
	public String hola() {
		return "Hola que tal";
	}
	@GetMapping("/tabla")
	public String tablaMultiplicar(@RequestParam(value = "num", defaultValue = "7") Integer num) {
		String res="";
		for(int i=1;i<=10;i++) {
			res+=i+" x "+num+" = "+(i*num);
		}
		return res;
	}
}
