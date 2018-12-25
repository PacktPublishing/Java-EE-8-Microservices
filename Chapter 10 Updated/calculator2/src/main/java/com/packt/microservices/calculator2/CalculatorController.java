package com.packt.microservices.calculator2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * 
 * This class implements Calculator functions
 * @author packt
 *
 */
@RestController
public class CalculatorController {
	
	FetchConstantService fetchConstantService = new  FetchConstantService();
	CalculatorController(){
		
	}
	
	CalculatorController(FetchConstantService fetchConstantService){
		this.fetchConstantService = fetchConstantService;
	}
	/**
	 * @api {get} /add?num1={num1}&num2={num2} Request to add 2 numbers
	 * @apiName Add
	 * @apiGroup Calculate
	 * @apiVersion 1.0.0
	 * 
	 * @apiParam {Number} num1 first number
	 * @apiParam {Number} num2 second number 
	 *
	 * @apiSuccess {Number} Sum of the two numbers.
	 */
	@GetMapping("/add")
	public int addNumber(int num1, int num2) {
		return(num1+num2);
	}
	
	/**
	 * @api {get} /subtract?num1={num1}&num2={num2} Request to subtract 2 numbers
	 * @apiName Subtract
	 * @apiGroup Calculate
	 * @apiVersion 1.0.0
	 *
	 * @apiParam {Number} num1 first number
	 * @apiParam {Number} num2 second number 
	 * 
	 * @apiSuccess {Number} Difference of the two numbers.
	 */
	@GetMapping("/subtract")
	public int subtractNumber(int num1, int num2) {
		return(num1-num2);
	}
	
	/**
	 * @api {get} /multiply?num1={num1}&num2={num2} Request to multiply 2 numbers
	 * @apiName Multiply
	 * @apiGroup Calculate
	 * @apiVersion 1.0.0
	 *
	 * @apiParam {Number} num1 first number
	 * @apiParam {Number} num2 second number 
	 * 
	 * @apiSuccess {Number} Product of the two numbers.
	 */
	@GetMapping("/multiply")
	public int multiplyNumber(int num1, int num2) {
		return(num1*num2);
	}
	
	/**
	 * @api {get} /divide?num1={num1}&num2={num2} Request to divide 2 numbers
	 * @apiName Divide
	 * @apiGroup Calculate
	 * @apiVersion 1.0.0
	 *
	 * @apiParam {Number} num1 first number
	 * @apiParam {Number} num2 second number 
	 * 
	 * @apiSuccess {Number} Quotient when num1 is divided by num2.
	 */
	@GetMapping("/divide")
	public float divideNumber(float num1, float num2) {
		return(float)(num1/num2);
	}

	/**
	 * @api {get} /dividebyconstant?num1={num1}&num2={num2} Request to divide 2 numbers
	 * @apiName Divide
	 * @apiGroup Calculate
	 * @apiVersion 1.0.0
	 *
	 * @apiParam {Number} num1 first number
	 * 
	 * @apiSuccess {Number} Quotient when num1 is divided by constant.
	 */
	@GetMapping("/dividebyconstant")
	public float divideNumberByConstant(float num1) { 
		float num2;
		try {
			num2 = fetchConstant();
		}
		catch(Exception e) {
			// In real code we will handle multiple exceptions expected and not just the high level exception
			
			// Once an error occur, we will need to handle it.
			// We will need to log proper error and handle it gracefully so that or code does not break.
			num2 = 2;
		}
		return(float)(num1/num2);
	}
	
	/***
	 * This method return a constant value based on a third party service
	 * @return
	 */
	public float fetchConstant() {
		return fetchConstantService.getConstantValue();
	}
}
