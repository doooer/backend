package com.plog.doooer.domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Table(name = "TB_TEAM")
@Entity
@Data
@RequiredArgsConstructor
public class TeamEntity {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AI
	private long id;
	
	@Column(name = "TEAM_NM", length = 90)
	private String teamNm; //팀 이름
	
	@Column(name = "TEAM_IMG", length = 50)
	private String teamImg; //팀 로고이미지
	
	@Column(name = "TEAM_INFO")
	private String teamInfo; //팀 정보
	
	@Column(name = "FROM_DT")
	private Date fromDt; //팀 결성일 = 모집 시작일. 모든 직군의 모집이 마감되는 경우 결성일 생성.
	
	@Column(name = "TO_DT")
	private Date toDt; //팀 종료일 = 프로젝트 종료일 또는 팀 포트폴리오 작성일. 포트폴리오 작성 시 종료일 생성?
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "TEAM_ID")
	private Collection<MemberEntity> memberList;
	
	@OneToOne
	@JoinColumn(name = "RCT_ID")
	private RecruitmentEntity rctEntity;
	

	@Builder
	public TeamEntity(long id, String teamNm, String teamImg, String teamInfo,
			RecruitmentEntity rctEntity, Date fromDt, Date toDt) {
		super();
		this.id = id;
		this.teamNm = teamNm;
		this.teamImg = teamImg;
		this.teamInfo = teamInfo;
//		this.rctId = rctId;
		this.rctEntity = rctEntity;
		this.fromDt = fromDt;
		this.toDt = toDt;
	}
	
//	public void toDto() {
//		
//	}
	
	

}
