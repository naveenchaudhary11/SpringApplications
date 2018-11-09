package com.tadigital.controllers;

import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tadigital.entity.Vendor;
import com.tadigital.service.VendorService;

@Controller
@RequestMapping(value = "/register")
public class RegisterController {
	
	private VendorService vs;
	
	@Autowired
	public RegisterController(VendorService vs) {
		this.vs = vs;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String loadRegisterForm() {
		return "html/registerForm.html";
	}

	@PostMapping
	public String registerTask(@ModelAttribute Vendor vendor, @RequestParam("imgPart") Part imgPart) {
		
		vendor.setImgPart(imgPart);
		
		boolean b = vs.registerVendor(vendor);
		
		if(b) {
			return "registrationSuccess.jsp";
		}
		return "registrationFailure.jsp";
	}
}
