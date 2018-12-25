package com.packt.microservices.calculator2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;


@RunWith(SpringRunner.class)
@SpringBootTest
//@WebMvcTest(CalculatorController.class)
public class Calculator2ApplicationTests {

	/**
	 * This method tests division of 2 integers
	 */
	@Test
	public void divideIntegerSuccessTest() {
		CalculatorController calculatorController = new CalculatorController();
		int num1 = 10;
		int num2 = 5;
		float expectedResult = 2;
		float actualResult = calculatorController.divideNumber(num1, num2);
		assertEquals(expectedResult, actualResult, 0);
	}
	
	/**
	 * This method tests for division of two float numbers 
	 */
	@Test
	public void divideFloatSuccessTest() {
		CalculatorController calculatorController = new CalculatorController();
		float num1 = (float) 55.5;
		float num2 = (float) 11.1;
		float expectedResult = 5;
		float actualResult = calculatorController.divideNumber(num1, num2);
		assertEquals(expectedResult, actualResult, 0);
	}
	
	/**
	 * This method tests for division by negative numbers 
	 */
	@Test
	public void divideFloatNegativeSuccessTest() {
		CalculatorController calculatorController = new CalculatorController();
		float num1 = (float) -55.5;
		float num2 = (float) -11.1;
		float expectedResult = 5;
		float actualResult = calculatorController.divideNumber(num1, num2);
		assertEquals(expectedResult, actualResult, 0);
	}
	
	/**
	 * This method tests for division by negative numbers 
	 */
	@Test
	public void divideByZeroTest() {
		CalculatorController calculatorController = new CalculatorController();
		int num1 = 30;
		int num2 = 0;
		float expectedResult = Float.POSITIVE_INFINITY;
		float actualResult = calculatorController.divideNumber(num1, num2);
		assertEquals(expectedResult, actualResult, 0);
	}
	
	/**
	 * This method tests divide by constant
	 */
	@Test
	public void divideByConstantSuccessTest() {
		FetchConstantService fetchConstantService = Mockito.mock(FetchConstantService.class);
        when(fetchConstantService.getConstantValue()).thenReturn((float) 2);
		CalculatorController calculatorController = new CalculatorController(fetchConstantService);
		int num1 = 10;
		// define return value for method getUniqueId()
		float expectedResult = 5;
		float actualResult = calculatorController.divideNumberByConstant(num1);
		assertEquals(expectedResult, actualResult, 0);
	}
	
	/**
	 * This method tests divide by constant- no mocks
	 */
	@Test
	public void divideByConstantSuccessNoMockTest() {
		FetchConstantService fetchConstantService = new FetchConstantService();
		CalculatorController calculatorController = new CalculatorController(fetchConstantService);
		int num1 = 10;
		// define return value for method getUniqueId()
		float expectedResult = 2;
		float actualResult = calculatorController.divideNumberByConstant(num1);
		assertEquals(expectedResult, actualResult, 0);
	}
	
}
