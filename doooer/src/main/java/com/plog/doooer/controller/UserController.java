package com.plog.doooer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plog.doooer.service.LoginRequestDTO;
import com.plog.doooer.service.SignupRequestDTO;
import com.plog.doooer.service.UserService;
import com.plog.doooer.util.JwtUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/")
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping("/signup")
	@ApiOperation(value = "회원 가입", notes = "회원 가입")
	@ApiImplicitParams({ 
			@ApiImplicitParam(name = "name", value = "이름", required = true, defaultValue = "김두어"),
			@ApiImplicitParam(name = "password", value = "패스워드", required = true, defaultValue = "pw486"),
			@ApiImplicitParam(name = "email", value = "이메일", required = true, defaultValue = "admin@doooer.io")})
	public String signup(@RequestBody SignupRequestDTO signupRequestDTO) {
		System.out.println(signupRequestDTO);
		return userService.signup(signupRequestDTO);
	}
	
	@PostMapping("/login")
	@ApiOperation(value = "로그인", notes = "로그인")
	@ApiImplicitParams({ 
			@ApiImplicitParam(name = "email", value = "이메일", required = true, defaultValue = "admin@doooer.io"),
			@ApiImplicitParam(name = "password", value = "패스워드", required = true, defaultValue = "pw486")})
	public String getLoginForm(@RequestBody LoginRequestDTO loginRequestDTO) throws Exception {
		System.out.println(loginRequestDTO);
		String token = userService.generateToken(loginRequestDTO);
		
		return token;
	}
	
}
