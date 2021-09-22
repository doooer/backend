package com.plog.doooer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plog.doooer.common.PlogException;
import com.plog.doooer.common.PlogExceptionEnum;

@RestController
@RequestMapping("/api/")
public class HomeController {
	
	@RequestMapping("/home")
	public void home() {
	}
}
