package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.service.DefaultGreetingService;
import com.example.service.GreetingService;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public GreetingService getGreetingService() {
		return new DefaultGreetingService();
	}
	
	public void run(String... args) throws Exception {
		DefaultGreetingService temp = new DefaultGreetingService();
		temp.greet();
		//getGreetingService.greet();
	}

}
