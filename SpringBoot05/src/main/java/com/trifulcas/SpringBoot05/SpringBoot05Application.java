package com.trifulcas.SpringBoot05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({ "com.trifulcas" })
@EntityScan("com.trifulcas.models")
@EnableJpaRepositories("com.trifulcas.repository")

public class SpringBoot05Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot05Application.class, args);
	}

}
