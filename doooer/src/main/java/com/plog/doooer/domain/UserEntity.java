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

/*@ToString 
@AllArgsConstructor  
*/

//@
@Table(name = "tb_user")
@Entity
@Data
@NoArgsConstructor
public class UserEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) // mysql의 AUTO_INCREMENT를 그대로 사용
	private Long id;

	@Column(length = 20, nullable = false)
	private String name;

	@Column(length = 40, unique = true, nullable = false)
	private String email;

	@Column(length = 40, nullable = false)
	private String pw;

	@Column(length = 20, nullable = false)
	private String region;
	
	@Column(length = 20, nullable = false)
	private String major;
	
	@Column(length = 40)
	private String profile_img_id;
	
	@Column(length = 20)
	private String number;
	
	@Column(length = 2)
	private String number_open_yn;
	
	@Column(length = 2)
	private String portfolio_open_yn;
	
	@Column(length = 2)
	private String message_open_yn;

	@Column(updatable = false)
	@CreatedDate
	private LocalDateTime created_dt;
	
	@LastModifiedDate
	private LocalDateTime updated_dt;

	@Builder
	public UserEntity(String name, String pw, String email, String region, String major, String profile_img_id, String number, String number_open_yn, String portfolio_open_yn, String  message_open_yn, LocalDateTime created_dt, LocalDateTime updated_dt) { 
		this.name = name; 
		this.pw = pw;
		this.email = email;
		this.region = region; 
		this.major = major; 
		this.profile_img_id = profile_img_id; 
		this.number = number; 
		this.number_open_yn = number_open_yn;
		this.portfolio_open_yn = portfolio_open_yn; 
		this.message_open_yn = message_open_yn; 
		this.created_dt = created_dt;
		this.updated_dt = updated_dt;
		}
}
