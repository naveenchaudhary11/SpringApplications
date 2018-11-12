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
@RequestMapping(value = "/login")
public class LoginController {
	private static final Logger LOGGER = Logger.getLogger(LoginController.class);
	private VendorService vs;
	
	@Autowired
	public LoginController(VendorService vs) {
		this.vs = vs;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String loadLoginForm() {
		LOGGER.info("loadLoginForm Controller executing");
		LOGGER.info("loadLoginForm Controller finishing");
		return "loginForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String loginTask(@ModelAttribute Vendor v, HttpServletRequest req) {
		LOGGER.info("loginTask Controller executing");
		boolean b = vs.loginVendor(v);
		LOGGER.info("loginTask Controller finishing");
		if(b) {
			return "loginSuccess";
		}
		return "loginFailure";
	}
}
