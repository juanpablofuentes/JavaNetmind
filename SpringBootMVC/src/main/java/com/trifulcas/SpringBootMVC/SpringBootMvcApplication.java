package com.trifulcas.SpringBootMVC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.trifulcas")
@EntityScan("com.trifulcas.models")
@EnableJpaRepositories("com.trifulcas.repositories")
public class SpringBootMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMvcApplication.class, args);
	}

}
