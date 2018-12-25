package com.servicetwo.servicetwo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {
	
	private final RestTemplate restTemplate;
	
	public HelloController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@GetMapping("/sayhello2")
	public String sayHello() {
		String responseFromService = restTemplate.getForObject("http://localhost:8082/sayhello3", String.class);
		return("Hello from service 2. " + responseFromService);
	}

}
