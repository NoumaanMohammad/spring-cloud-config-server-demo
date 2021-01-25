package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@SpringBootApplication
@RestController
@EnableHystrix
@EnableHystrixDashboard
public class BookMyShowHystrixApplication {

	@Autowired
	RestTemplate template;
	
	public static void main(String[] args) {
		SpringApplication.run(BookMyShowHystrixApplication.class, args);
	}

	@Bean
	public RestTemplate template () {
		return new RestTemplate();
	}
	
	@GetMapping("/bookticket")
	@HystrixCommand(groupKey = "bookTicket1" , commandKey = "bookTicket1" , fallbackMethod = "fallbackMethod")
	public String bookTicket() {
		return template.getForObject("http://localhost:8081/payment", String.class)+"\n"+template.getForObject("http://localhost:8082/notification", String.class);
	}
	
	@GetMapping("/bookticket2")
	@HystrixCommand(groupKey = "bookTicket2" , commandKey = "bookTicket2" , fallbackMethod = "fallbackMethod")
	public String bookTicket2() {
		return template.getForObject("http://localhost:8081/payment", String.class)+"\n"+template.getForObject("http://localhost:8082/notification", String.class);
	}
	
	public String fallbackMethod() {
		return "service gateway failed";
	}
}
