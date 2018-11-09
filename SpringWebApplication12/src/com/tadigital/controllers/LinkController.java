package com.tadigital.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LinkController {
	
	@GetMapping(value= {"/","/home"})
	public String reloadHome() {
		return "index.jsp";
	}

}
