package com.boot.ms.InitialDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InitialDemoApplication {

	@Autowired
	GreetingRepo repo;
	public static void main(String[] args) {
		SpringApplication.run(InitialDemoApplication.class, args);
	}

	@Bean
	CommandLineRunner dlr(ApplicationContext ctx) {
		return s -> {

			String beans[] = ctx.getBeanDefinitionNames();
			System.out.println("Bean Count = " + beans.length);
			/*
			 * for (int i = 0; i < beans.length; i++) { System.out.println(beans[i]); }
			 */
			
			repo.save(new Greeting(1,"Hello"));
			repo.save(new Greeting(2,"Hola"));
			repo.save(new Greeting(3,"Namaskara"));
			
			
		};

	}
}
