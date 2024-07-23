package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@ComponentScan({"com.example.demo"})
@EntityScan("com.example.demo")
@EnableJpaRepositories("com.example.demo.repository")
public class LangSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(LangSearchApplication.class, args);
	}

}
