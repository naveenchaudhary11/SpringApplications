package com.tadigital.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LinkController {
	
	@RequestMapping(value= {"/","/home"})
	public String reloadHome() {
		return "index.jsp";
	}
	
	@RequestMapping(value= "/loginform")
	public String loadLoginForm() {
		return "LoginForm.jsp";
	}
	
	@RequestMapping(value= "/registerform")
	public String loadRegistrationForm() {
		return "LoginForm.jsp";
	}
	
	/*@RequestMapping(value= "/loginform")
	public String loadLoginForm() {
		return "LoginForm.jsp";
	}
	*/
}
