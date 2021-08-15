package com.plog.doooer.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "tb_user")
@Entity
@Data
@NoArgsConstructor
public class UserEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) // mysql의 AUTO_INCREMENT를 그대로 사용
	private Long id;

	@Column(length = 255, nullable = false)
	private String name;

	@Column(length = 255, unique = true, nullable = false)
	private String email;

	@Column(nullable = false)
	private String password;

	@Column(length = 255)
	private String job_cd;
	
	@Column(length = 255)
	private String prfl_img_id;
	 
	@Column(length = 300)
	private String introduce;
	
	@Column(name = "auth")
	private String auth;

	@Column(updatable = false)
	@CreatedDate
	private LocalDateTime created_dt;
	
	@LastModifiedDate
	private LocalDateTime updated_dt;

	@Builder
	public UserEntity(String name, String password, String email, String job_cd, String prfl_img_id, String introduce, String auth, LocalDateTime created_dt, LocalDateTime updated_dt) { 
		this.name = name; 
		this.password = password;
		this.email = email;
		this.job_cd = job_cd;
		this.prfl_img_id = prfl_img_id;
		this.introduce = introduce;
		this.auth = auth;
		this.created_dt = created_dt;
		this.updated_dt = updated_dt;
	}
}
