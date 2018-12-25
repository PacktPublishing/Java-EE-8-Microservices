package com.serviceone.serviceone;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {
	
	private final RestTemplate restTemplate;
	
	public HelloController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@GetMapping("/sayhello")
	public String sayHello() {
		String responseFromService = restTemplate.getForObject("http://localhost:8081/sayhello2", String.class);
		return("Hello from service 1. " + responseFromService);
	}

}
