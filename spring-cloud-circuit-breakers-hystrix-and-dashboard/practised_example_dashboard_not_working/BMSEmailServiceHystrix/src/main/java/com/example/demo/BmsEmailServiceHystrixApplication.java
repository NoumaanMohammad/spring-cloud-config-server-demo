package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BmsEmailServiceHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(BmsEmailServiceHystrixApplication.class, args);
	}

	@GetMapping("/notification")
	public String payment() {
		return "Email sent to user";
	}
}
