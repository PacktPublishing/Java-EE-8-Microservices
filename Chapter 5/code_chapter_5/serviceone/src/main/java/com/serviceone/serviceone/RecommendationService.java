package com.serviceone.serviceone;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class RecommendationService {

  private final RestTemplate restTemplate;

  public RecommendationService(RestTemplate rest) {
    this.restTemplate = rest;
  }

  @HystrixCommand(fallbackMethod = "reliable")
  public String recommend() {
    URI uri = URI.create("http://localhost:8081/movies");
    return this.restTemplate.getForObject(uri, String.class);
  }

  public String reliable() {
    return "Top 3 Movies for the month. \n 1. Batman Begins\n 2. Interstellar\n 3. Justice League. ";
  }

}