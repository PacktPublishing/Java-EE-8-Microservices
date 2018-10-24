package com.serviceone.serviceone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableCircuitBreaker
@RestController
@SpringBootApplication
public class ServiceoneApplication {

	@Autowired
	private RecommendationService recommendationService;
	
	public static void main(String[] args) {
		SpringApplication.run(ServiceoneApplication.class, args);
	}
	
	@Bean
	  public RestTemplate rest(RestTemplateBuilder builder) {
	    return builder.build();
	  }

	  @RequestMapping("/movies")
	  public String getRecommendedMovies() {
	    return recommendationService.recommend();
	  }
}
