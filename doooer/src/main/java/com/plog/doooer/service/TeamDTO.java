package com.plog.doooer.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.plog.doooer.domain.MemberEntity;
import com.plog.doooer.domain.RecruitmentEntity;
import com.plog.doooer.domain.TeamEntity;

public class TeamDTO {
	private long rctId;
	private long id;
	private String teamNm; //팀 이름
	private String teamImg; //팀 로고이미지
	private String teamInfo; //팀 정보
	private Date fromDt; //팀 결성일 = 모집 시작일. 모든 직군의 모집이 마감되는 경우 결성일 생성.
	private Date toDt; //팀 종료일 = 프로젝트 종료일 또는 팀 포트폴리오 작성일. 포트폴리오 작성 시 종료일 생성?
	

	public TeamEntity toEntity() {
		return TeamEntity.builder()
				.teamNm(teamNm)
				.teamImg(teamImg)
				.teamInfo(teamInfo)
				.fromDt(fromDt)
				.toDt(toDt)
				.build();
	}

}
