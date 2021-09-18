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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "tb_user")
@Entity
@Getter
@Setter
@ToString
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
	private String jobCd;
	
	@Column(length = 255)
	private String prflImgId;
	 
	@Column(length = 300)
	private String introduce;
	
	@Column(name = "auth")
	private String auth;

	@Column(updatable = false)
	@CreatedDate
	private LocalDateTime createdDt;
	
	@LastModifiedDate
	private LocalDateTime updatedDt;

	@Builder
	public UserEntity(String name, String password, String email, String job_cd, String prfl_img_id, String introduce, String auth, LocalDateTime created_dt, LocalDateTime updated_dt) { 
		this.name = name; 
		this.password = password;
		this.email = email;
		this.jobCd = job_cd;
		this.prflImgId = prfl_img_id;
		this.introduce = introduce;
		this.auth = auth;
		this.createdDt = created_dt;
		this.updatedDt = updated_dt;
	}
	
	public void updateAuth(String auth) {
		this.auth = auth;
	}
	
	public void updatePassword(String password) {
		this.password = password;
	}
	
	public void updateCreatedDt(LocalDateTime createdDt) {
		this.createdDt = createdDt;
	}
}
