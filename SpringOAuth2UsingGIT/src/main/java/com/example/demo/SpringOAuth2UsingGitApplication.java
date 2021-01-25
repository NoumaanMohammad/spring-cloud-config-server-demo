package com.example.demo;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableOAuth2Sso
public class SpringOAuth2UsingGitApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringOAuth2UsingGitApplication.class, args);
	}
	
	@GetMapping("/")
	public String simpleMethod(Principal p) {
		
		return "Hi "+p.getName()+". i got authorised from git to use your data.thank you";
	}

}
