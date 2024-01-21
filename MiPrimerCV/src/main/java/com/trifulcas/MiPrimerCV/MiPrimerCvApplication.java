package com.trifulcas.MiPrimerCV;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.trifulcas")
public class MiPrimerCvApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiPrimerCvApplication.class, args);
	}

}
