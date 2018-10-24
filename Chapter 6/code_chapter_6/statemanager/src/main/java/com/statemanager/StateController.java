package com.statemanager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class StateController {
	
	@GetMapping("/setSession")
	public String sayHello(HttpServletRequest req) {
		HttpSession sess = req.getSession(true);
		sess.setAttribute("isAuthenticated", true);
		User user = new User();
		user.setId("1");
		user.setName("someName");
		return new JWTUtil().createAccessJwtToken(user);
	}

}
