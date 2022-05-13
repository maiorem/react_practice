package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestApplication {
 
	
	
	public TestApplication() {
		super();
		System.out.println("****************************************");
	}

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

}
