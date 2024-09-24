package com.example.HelloWorld1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.Order;

@Order(2)
@SpringBootApplication
public class HelloWorld1Application implements CommandLineRunner {

	public static void main(String[] args) {
		System.out.println("Begin of main");
		SpringApplication.run(HelloWorld1Application.class, args);
		System.out.println("End of main");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello from Spring Boot");
	}
}
