package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class ShoppingServiceApplication {

	@Autowired
	RestTemplate template;
	
	public static void main(String[] args) {
		SpringApplication.run(ShoppingServiceApplication.class, args);
	}

	@LoadBalanced
	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}
	
	@GetMapping("/makePayment/{amount}")
	public String completeOrder(@PathVariable int amount) {
		String url = "http://PAYMENT-SERVICE/payment/payNow/"+amount;
		return template.getForObject(url, String.class);
	}
}
