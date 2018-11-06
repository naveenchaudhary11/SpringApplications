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
public class RegistrationController {
	
	private VendorService vs;
	
	@Autowired
	public RegistrationController(VendorService vs) {
		this.vs = vs;
	}
	
	@RequestMapping(value= "/register")
	public String loadRegistrationForm() {
		return "RegisterForm.jsp";
	}


	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String loginTask(@ModelAttribute Vendor vendor,HttpServletRequest req) {
		
		
		boolean b = vs.registerVendor(vendor);
		
		if(b) {
			return "registerSuccess.jsp";
		}
		return "registerFailure.jsp";
	}
}
