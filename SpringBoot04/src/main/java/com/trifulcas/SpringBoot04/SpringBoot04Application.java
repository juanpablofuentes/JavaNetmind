package com.trifulcas.SpringBoot04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.trifulcas")
public class SpringBoot04Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot04Application.class, args);
	}

}
