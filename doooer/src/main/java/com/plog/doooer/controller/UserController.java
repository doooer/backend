package com.plog.doooer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plog.doooer.common.PlogException;
import com.plog.doooer.common.PlogExceptionEnum;
import com.plog.doooer.service.LoginRequestDTO;
import com.plog.doooer.service.LoginResponseDTO;
import com.plog.doooer.service.ResponseDTO;
import com.plog.doooer.service.SignupRequestDTO;
import com.plog.doooer.service.UpdateUserInfoRequestDTO;
import com.plog.doooer.service.UserService;

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
	public ResponseDTO signup(@RequestBody SignupRequestDTO signupRequestDTO) {
		ResponseDTO resDto = new ResponseDTO();
		resDto.setResCd("0000");
		resDto.setResMsg("회원가입에 성공했습니다.");
		
		return resDto;
	}
	
	@PostMapping("/login")
	@ApiOperation(value = "로그인", notes = "로그인")
	@ApiImplicitParams({ 
			@ApiImplicitParam(name = "email", value = "이메일", required = true, defaultValue = "admin@doooer.io"),
			@ApiImplicitParam(name = "password", value = "패스워드", required = true, defaultValue = "pw486")})
	public ResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO) throws Exception {
		String token = userService.generateToken(loginRequestDTO);
		
		LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
		ResponseDTO resDto = new ResponseDTO();
		
		loginResponseDTO.updateId(userService.getUserInfo(token).getId());
		loginResponseDTO.updateAuth(userService.getUserInfo(token).getAuth());
		loginResponseDTO.updateEmail(userService.getUserInfo(token).getEmail());
		loginResponseDTO.updateName(userService.getUserInfo(token).getName());
		loginResponseDTO.updatePrflImgId(userService.getUserInfo(token).getPrflImgId());
		loginResponseDTO.updateToken(token);
		
		resDto.setResCd("0000");
		resDto.setResMsg("로그인에 성공했습니다.");
		resDto.setData(loginResponseDTO);
		
		return resDto;
	}
	
	@PostMapping("/updateUserInfo")
	@ApiOperation(value = "프로필 수정", notes = "프로필 수정")
	@ApiImplicitParams({})
	public ResponseDTO updateUserInfo(@RequestBody UpdateUserInfoRequestDTO updateUserInfoRequestDTO) throws Exception {
		ResponseDTO resDto = new ResponseDTO();
		
		userService.updateUserInfo(updateUserInfoRequestDTO);
		
		resDto.setResCd("0000");
		resDto.setResMsg("업데이트에 성공했습니다.");
		
		return resDto;
	}
	
}
