package com.tadigital.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LinkController {
	private static final Logger LOGGER = Logger.getLogger(LinkController.class);
	
	@RequestMapping(value= {"/","/home"})
	public String reloadHome() {
		LOGGER.info("reloadHome Controller executing");
		LOGGER.info("reloadHome Controller finishing");
		return "index";
	}

}
