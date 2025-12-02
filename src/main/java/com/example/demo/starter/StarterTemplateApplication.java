package com.example.demo.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.demo.starter")
@EntityScan(basePackages = "com.example.demo.starter")
public class StarterTemplateApplication {
	public static void main(String[] args) {
		SpringApplication.run(StarterTemplateApplication.class, args);
	}
}
