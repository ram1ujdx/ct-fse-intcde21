package com.cts.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	
	@GetMapping("/")
	public String sayHello() {
		return "Hello Everyone.. This is the version 2";
	}
	
	
}
