package com.cts.microservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	@GetMapping
	public String sayHello() {
		return "Hello World";
	}
	
	@GetMapping("/user")
	public String userMethod() {
		return "Hello User";
	}
	
	@GetMapping("/admin")
	public String adminMethod() {
		return "Hello Admin";
	}
}
