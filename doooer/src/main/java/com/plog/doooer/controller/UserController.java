package com.plog.doooer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plog.doooer.service.UserDTO;
import com.plog.doooer.service.UserService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/")
public class UserController {
	@Autowired
	UserService userService;

	@RequestMapping("/register")
	@ApiOperation(value = "유저 등록", notes = "유저를 등록한다.")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "name", value = "이름", required = true, defaultValue = "삼두"),
			@ApiImplicitParam(name = "pw", value = "패스워드", required = true, defaultValue = "password486"),
			@ApiImplicitParam(name = "email", value = "이메일", required = true, defaultValue = "admin@3do.com"),
			@ApiImplicitParam(name = "region", value = "지역", required = true, defaultValue = "서울"),
			@ApiImplicitParam(name = "major", value = "직무", required = true, defaultValue = "개발자"),})
	public String register(UserDTO userDto) {
		
		System.out.println(userDto.toString());
		return userService.register(userDto);
	}
}
