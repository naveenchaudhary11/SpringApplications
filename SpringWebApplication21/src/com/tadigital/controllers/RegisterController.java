package com.tadigital.controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tadigital.entity.Vendor;
import com.tadigital.service.VendorService;

@Controller
@RequestMapping(value = "/register")
public class RegisterController {
	
	private VendorService vendorServiceProxy;
	
	@Autowired
	public RegisterController(VendorService vendorServiceProxy) {
		this.vendorServiceProxy = vendorServiceProxy;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String loadRegisterForm() {
		return "registerForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String registerTask(@ModelAttribute Vendor v,HttpServletRequest req) {
		boolean b = vendorServiceProxy.registerVendor(v);
		if(b) {
			return "registrationSuccess";
		}
		return "registrationFailure";
	}
}
