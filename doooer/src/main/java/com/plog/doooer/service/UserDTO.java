package com.plog.doooer.service;

import com.plog.doooer.domain.UserEntity;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class UserDTO {

	private String name;
	private String pw;
	private String email;
	private String region;
	private String major;
//	private String profile_img_id;
//	private String number;
//	private String number_open_yn;
//	private String portfolio_open_yn;
//	private String message_open_yn;
//	private LocalDateTime created_dt;
//	private LocalDateTime updated_dt;
	
    public UserEntity toEntity(){
        return UserEntity.builder()
                .name(name)
                .pw(pw)
                .email(email)
                .major(major)
                .region(region)
                //.profile_img_id(profile_img_id)
                //.number(number)
                //.number_open_yn(number_open_yn)
                //.portfolio_open_yn(portfolio_open_yn)
                //.message_open_yn(message_open_yn)
                //.created_dt(created_dt)
                //.updated_dt(updated_dt)
                .build();
    }
}
