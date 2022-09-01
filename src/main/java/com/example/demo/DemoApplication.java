package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.service.DefaultGreetingService;
import com.example.service.GreetingService;
import com.example.inputreader.DifferenceFinder;
import com.example.inputreader.InputReader;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public GreetingService getGreetingService() {
		return new DefaultGreetingService();
	}
	
	@Override
	public void run(String... args) throws Exception {
		DefaultGreetingService greeter = new DefaultGreetingService();
		greeter.greet();
		//getGreetingService.greet();
		
		InputReader file1 = new InputReader("./Example CSV 1 - Sheet1.csv");
		InputReader file2 = new InputReader("./Example CSV 2 - Sheet1.csv");
		
		DifferenceFinder df = new DifferenceFinder(file1, file2);
		df.findChanges();
	}

}
