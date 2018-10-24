package com.statemanager;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SumController {
	
	@GetMapping("/sum")
	public Integer sayHello(@RequestParam Integer num1, @RequestParam Integer num2) {
		return num1+num2;
	}

}
