package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping(value = "/insurance-service")
public class InsuranceProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceProviderApplication.class, args);
	}

	@GetMapping(value = "/getAllPlans")
	public List<String> getAllPlans() {
		return Stream.of("Gold","premium","platinum").collect(Collectors.toList());
	}
}
