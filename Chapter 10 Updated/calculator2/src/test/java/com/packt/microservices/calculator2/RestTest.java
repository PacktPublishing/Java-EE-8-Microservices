package com.packt.microservices.calculator2;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@RunWith(SpringRunner.class)
@WebMvcTest(CalculatorController.class)
public class RestTest {

    @Autowired
    private MockMvc mvc;
    
	@Test
	public void testRESTAdd()
	  throws Exception {
	 
	   mvc.perform( MockMvcRequestBuilders.get("/add?num1=1&num2=2"))
	    		 .andExpect(MockMvcResultMatchers.status().isOk())
	    		 .andExpect(MockMvcResultMatchers.content().string("3"));
	}
	
}
