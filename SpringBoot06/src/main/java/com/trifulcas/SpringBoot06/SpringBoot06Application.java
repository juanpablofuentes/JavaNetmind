package com.trifulcas.SpringBoot06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({ "com.trifulcas" })
@EntityScan("com.trifulcas.models")
@EnableJpaRepositories("com.trifulcas.repositories")

public class SpringBoot06Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot06Application.class, args);
	}

}
