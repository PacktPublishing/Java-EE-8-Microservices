package com.servicetwo.servicetwo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RecommendationController {
	
	private final RestTemplate restTemplate;
	
	public RecommendationController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@GetMapping("/movies")
	public String getRecommendedMovies() {
		// Applies number cruncher algo and come up with movies for logged in used
		return("Movies Recommended for you. \n 1. Jumanji: Welcome to the Jungle. \n2. Inception \n3. The Dark knight.");
	}

}
