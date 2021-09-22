package com.plog.doooer.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginResponseDTO {
	private String token;
	private long id;
	private String name;
	private String email;
	private String prflImgId;
	private String auth;
	
	
	public void updateToken(String token) {
		this.token = token;
	}
	public void updateId(long id) {
		this.id = id;
	}
	public void updateAuth(String auth) {
		this.auth = auth;
	}
	public void updateName(String name) {
		this.name = name;
	}
	public void updateEmail(String email) {
		this.email = email;
	}
	public void updatePrflImgId(String prflImgId) {
		this.prflImgId = prflImgId;
	}
}
