package com.trifulcas.SpringBoot06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


// Las siguientes anotaciones nos sirven para
// registrar todas las clases de nuestro proyecto
@SpringBootApplication
// Este es para los controladores
@ComponentScan( "com.trifulcas" )
// Los modelos (POJO's)
@EntityScan("com.trifulcas.models")
// Los repositorios
@EnableJpaRepositories("com.trifulcas.repositories")

public class SpringBoot06Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot06Application.class, args);
	}

}
