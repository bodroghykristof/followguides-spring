package com.example.followguides.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.followguides.model.Greeting;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
	
	private static final AtomicLong REQUEST_COUNTER = new AtomicLong();
	private static final String TEMPLATE = "Hello %s!";
	
	@GetMapping()
	public Greeting displayGreeting(@RequestParam(value = "name", defaultValue = "guest") String name) {
		String message = String.format(TEMPLATE, name);
		return new Greeting(REQUEST_COUNTER.incrementAndGet(), message);
	}

}
