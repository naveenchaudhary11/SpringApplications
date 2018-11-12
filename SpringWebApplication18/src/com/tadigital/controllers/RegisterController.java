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
	
	private static final Logger LOGGER = Logger.getLogger(RegisterController.class);
	private VendorService vs;
	
	@Autowired
	public RegisterController(VendorService vs) {
		this.vs = vs;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String loadRegisterForm() {
		LOGGER.info("loadRegisterForm Controller executing");
		LOGGER.info("loadRegisterForm Controller finishing");
		return "registerForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String registerTask(@ModelAttribute Vendor v,HttpServletRequest req) {
		LOGGER.info("registerTask Controller executing");
		boolean b = vs.registerVendor(v);
		LOGGER.info("registerTask Controller finishing");
		if(b) {
			return "registrationSuccess";
		}
		return "registrationFailure";
	}
}
