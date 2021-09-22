package com.plog.doooer.service;

import com.plog.doooer.domain.UserEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class SignupRequestDTO {

	private String name;
	private String password;
	private String email;
	
    public UserEntity toEntity(){
        return UserEntity.builder()
                .name(name)
                .email(email)
                .password(password)
                .build();
    }
}
