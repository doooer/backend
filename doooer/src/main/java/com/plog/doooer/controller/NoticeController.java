package com.plog.doooer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class NoticeController {
	
	@RequestMapping("/itNotice")
	public String itNotice() {
		
		return "itNotice";
	}
	
	@RequestMapping("/hackertonNotice")
	public String hackertonNotice() {
		
		return "hackertonNotice";
	}
}
