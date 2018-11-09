package com.tadigital.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tadigital.entity.Vendor;
import com.tadigital.service.VendorService;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
	
	private VendorService vs;
	
	@Autowired
	public LoginController(VendorService vs) {
		this.vs = vs;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String loadLoginForm() {
		return "html/loginForm.html";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String loginTask(@ModelAttribute Vendor v, HttpServletRequest req) {
		
		boolean b = vs.loginVendor(v);
		
		if(b) {
			return "loginSuccess.jsp";
		}
		return "loginFailure.jsp";
	}
}
