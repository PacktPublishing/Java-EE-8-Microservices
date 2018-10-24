package com.statemanager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SumSessionController {
	
	@GetMapping("/sum2")
	public Integer sayHello(@RequestParam String token, @RequestParam Integer num1, @RequestParam Integer num2) {
		User user = new JWTUtil().parseJwtToken(token);
		if(user.getSumAccess()) {
				return num1+num2;
		}
		return -9999;
		
	}

}
