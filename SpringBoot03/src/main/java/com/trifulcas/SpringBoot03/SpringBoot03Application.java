package com.trifulcas.SpringBoot03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.trifulcas")
public class SpringBoot03Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot03Application.class, args);
	}

}
