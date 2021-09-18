package com.plog.doooer.service;

import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class EmailSenderService {

	private JavaMailSender javaMailSender;
	
	@Autowired
	public EmailSenderService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	@Transactional
	@Async
	public String sendEmail(String email) {
		Random generator = new Random();
        generator.setSeed(System.currentTimeMillis());
        String randNum;
        randNum = Integer.toString(generator.nextInt(1000000) % 1000000);
		
	    MimeMessage message = javaMailSender.createMimeMessage();
	    MimeMessageHelper helper = new MimeMessageHelper(message);
	    try {
	      helper.setTo(email);
	      helper.setSubject("Doooer 회원 가입 인증 메일입니다.");
	      helper.setText("안녕하세요 Doooer 입니다. \n회원님의 인증 번호는 아래와 같습니다.\n" + randNum);
	    } catch (MessagingException e) {
	      e.printStackTrace();
	    }
	   
	    javaMailSender.send(message);
		
		return randNum;
	}
}