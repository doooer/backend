package com.plog.doooer.service;

import com.plog.doooer.domain.UserEntity;
import com.sun.istack.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class SignupRequestDTO {

	private String name;
	private String password;
	private String email;
	
	public boolean isValid() {
		return true;
	}
    public UserEntity toEntity(){
        return UserEntity.builder()
                .name(name)
                .email(email)
                .password(password)
                .build();
    }
}
