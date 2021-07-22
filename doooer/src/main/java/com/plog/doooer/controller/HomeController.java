package com.plog.doooer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class HomeController {
	
	@RequestMapping("/home")
	public String home() {
		
		return "home";
	}
}
