package com.packt.microservices.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="SimpleCalculator", description="Manages basic calculator operation on two numbers")
@RestController
public class CalculatorController {
	
	@ApiOperation(value = "Add given two numbers", response = Integer.class)
	@GetMapping("/add")
	public int addNumber(int num1, int num2) {
		return(num1+num2);
	}
	
	@ApiOperation(value = "Subract second number from first", response = Integer.class)
	@GetMapping("/subtract")
	public int subtractNumber(int num1, int num2) {
		return(num1-num2);
	}
	
	@ApiOperation(value = "Multiply two numbers", response = Integer.class)
	@GetMapping("/multiply")
	public int multiplyNumber(int num1, int num2) {
		return(num1*num2);
	}
	
	@ApiOperation(value = "Number one divided by second number", response = Float.class)
	@GetMapping("/divide")
	public float divideNumber(float num1, float num2) {
		return(float)(num1/num2);
	}

}
