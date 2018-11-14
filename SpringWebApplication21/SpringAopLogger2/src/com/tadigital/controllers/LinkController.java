package com.tadigital.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LinkController {
	
	@RequestMapping(value= {"/","/home"})
	public String reloadHome() {
		return "index";
	}

}
