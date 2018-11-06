package com.tadigital.ecommerce.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tadigital.ecommerce.entity.Vendor;
import com.tadigital.ecommerce.service.VendorService;

@Controller
public class LoginController {
	
	private VendorService vs;
	
	@Autowired
	public LoginController(VendorService vs) {
		this.vs = vs;
	}
	
	@RequestMapping(value= "/login")
	public String loadLoginForm() {
		return "LoginForm.jsp";
	}


	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String loginTask(@ModelAttribute Vendor vendor,HttpServletRequest req) {
		
		
		boolean b = vs.loginVendor(vendor);
		
		if(b) {
			return "loginSuccess.jsp";
		}
		return "loginFailure.jsp";
	}
}
