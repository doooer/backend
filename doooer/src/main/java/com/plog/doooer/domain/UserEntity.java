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

@Table(name = "TB_USER")
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

	@Column(name = "name", length = 255, nullable = false)
	private String name;

	@Column(name = "email", length = 255, unique = true, nullable = false)
	private String email;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "job_cd", length = 255)
	private String jobCd;
	
	@Column(name = "prfl_img_id", length = 255)
	private String prflImgId;
	 
	@Column(name = "introduce", length = 300)
	private String introduce;
	
	@Column(name = "auth")
	private String auth;

	@Column(name = "created_dt", updatable = false)
	@CreatedDate
	private LocalDateTime createdDt;
	
	@Column(name = "updated_dt")
	@LastModifiedDate
	private LocalDateTime updatedDt;

	@Builder
	public UserEntity(String name, String password, String email, String jobCd, String prflImgId, String introduce, String auth, LocalDateTime createdDt, LocalDateTime updatedDt) { 
		this.name = name; 
		this.password = password;
		this.email = email;
		this.jobCd = jobCd;
		this.prflImgId = prflImgId;
		this.introduce = introduce;
		this.auth = auth;
		this.createdDt = createdDt;
		this.updatedDt = updatedDt;
	}
	
	public void updateAuth(String auth) {
		this.auth = auth;
	}
	
	public void updatePassword(String password) {
		this.password = password;
	}
	
	public void updateName(String name) {
		this.name = name;
	}
	
	public void updateIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public void updatePrflImgId(String prflImgId) {
		this.prflImgId = prflImgId;
	}
	public void updateJobCd(String jobCd) {
		this.jobCd = jobCd;
	}
	public void updateCreatedDt(LocalDateTime createdDt) {
		this.createdDt = createdDt;
	}
}
