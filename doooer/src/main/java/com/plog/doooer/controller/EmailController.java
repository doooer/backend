package com.plog.doooer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plog.doooer.service.EmailSenderDTO;
import com.plog.doooer.service.EmailSenderService;

@RestController
@RequestMapping("/api/")
public class EmailController {
	@Autowired
	EmailSenderService emailSenderService;
	
	@PostMapping("/sendEmail")
	public String sendEmail(HttpServletRequest request, @RequestBody EmailSenderDTO emailSenderDTO) throws Exception {
		
		HttpSession session = request.getSession();
		String key = emailSenderService.sendEmail(emailSenderDTO.getEmail());

		session.setMaxInactiveInterval(60*3);
		session.setAttribute("key", key);
		
		return key;
	}
	
	@PostMapping("/checkKey")
	public Boolean checkKey(HttpServletRequest request, String certificateKey) throws Exception {
		
		HttpSession session = request.getSession();
		
		if (session == null || session.getAttribute("key") == null) {
			return false;
		}
		
		String key = session.getAttribute("key").toString();
		
		if (certificateKey.equals(key)) {
			return true;
		}
		
		return false;
	}
	
}
