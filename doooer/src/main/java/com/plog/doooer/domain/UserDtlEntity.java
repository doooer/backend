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

@Table(name = "tb_user_dtl")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDtlEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) // mysql의 AUTO_INCREMENT를 그대로 사용
	private Long id;

	@Column(name = "bkgrd_img_id", length = 255)
	private String bkgrdImgId;

	@Column(name = "use_tech")
	private String useTech;

	@Column(name = "hp", length = 255)
	private String hp;

	@Column(name = "education_list")
	private String educationList;
	
	@Column(name = "award_list")
	private String awardList;
	 
	@Column(name = "certificate_list")
	private String certificateList;
	
	@Column(name = "ref_link")
	private String refLink;
	
	@Column(name = "ref_link2")
	private String refLink2;
	
	@Column(name = "open_chat_url", length = 255)
	private String openChatUrl;
	
	@Column(name = "email_open_yn", length = 2)
	private String emailOpenYn;
	
	@Column(name = "number_open_yn", length = 2)
	private String numberOpenYn;
	
	@Column(name = "team_rct_notice_yn", length = 2)
	private String teamRctNoticeYn;
	
	@Column(name = "prfl_reply_notice_yn", length = 2)
	private String prflReplyNoticeYn;
	
	@Column(updatable = false)
	@CreatedDate
	private LocalDateTime createdDt;
	
	@LastModifiedDate
	private LocalDateTime updatedDt;

	@Builder
	public UserDtlEntity(String bkgrdImgId, String useTech, String hp, String educationList, 
			String awardList, String certificateList, String refLink, String refLink2, String openChatUrl,
			String emailOpenYn, String numberOpenYn, String teamRctNoticeYn, String prflReplyNoticeYn,
			LocalDateTime created_dt, LocalDateTime updated_dt) { 
		this.bkgrdImgId = bkgrdImgId;
		this.useTech = useTech;
		this.hp = hp;
		this.educationList = educationList;
		this.awardList = awardList;
		this.certificateList = certificateList;
		this.refLink = refLink;
		this.refLink2 = refLink2;
		this.openChatUrl = openChatUrl;
		this.emailOpenYn = emailOpenYn;
		this.numberOpenYn = numberOpenYn;
		this.teamRctNoticeYn = teamRctNoticeYn;
		this.prflReplyNoticeYn = prflReplyNoticeYn;
		this.createdDt = created_dt;
		this.updatedDt = updated_dt;
	}
	public void updateBkgrdImgId(String bkgrdImgId) {
		this.bkgrdImgId = bkgrdImgId;
	}
	public void updateUseTech(String useTech) {
		this.useTech = useTech;
	}
	public void updateHp(String hp) {
		this.hp = hp;
	}
	public void updateEducationList(String educationList) {
		this.educationList = educationList;
	}
	public void updateAwardList(String awardList) {
		this.awardList = awardList;
	}
	public void updateCertificateList(String certificateList) {
		this.certificateList = certificateList;
	}
	
	public void updateRefLink(String refLink) {
		this.refLink = refLink;
	}
	public void updateRefLink2(String refLink2) {
		this.refLink2 = refLink2;
	}
	public void updateOpenChatUrl(String openChatUrl) {
		this.openChatUrl = openChatUrl;
	}
	public void updateEmailOpenYn(String emailOpenYn) {
		this.emailOpenYn = emailOpenYn;
	}
	public void updateNumberOpenYn(String numberOpenYn) {
		this.numberOpenYn = numberOpenYn;
	}
	public void updateTeamRctNoticeYn(String teamRctNoticeYn) {
		this.teamRctNoticeYn = teamRctNoticeYn;
	}
	public void updatePrflReplyNoticeYn(String prflReplyNoticeYn) {
		this.prflReplyNoticeYn = prflReplyNoticeYn;
	}
	
	public void updateCreatedDt(LocalDateTime createdDt) {
		this.createdDt = createdDt;
	}
}
