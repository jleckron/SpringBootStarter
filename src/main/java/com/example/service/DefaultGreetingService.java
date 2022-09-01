package com.example.service;

public class DefaultGreetingService implements GreetingService {
	
	@Override
	public void greet() {
		System.out.println("Hello from standalone app starter");
	}
}