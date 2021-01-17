package com.example.followguides.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	
	@GetMapping("/")
	public String displayGreeting(@RequestParam(value = "name", defaultValue = "guest") String name) {
		System.out.println("Request");
		return String.format("Hello %s!", name);
	}

}
