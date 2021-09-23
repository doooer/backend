package com.plog.doooer.service;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.plog.doooer.domain.MemberEntity;
import com.plog.doooer.domain.TeamEntity;

public class MemberDTO {
	private long teamId;
	private long userId;
	private String memberSt; //멤버 상태. 예) 참여중, 중도이탈? 등
	private Date fromDt;

	public MemberEntity toEntity() {
		return MemberEntity.builder()
				.userId(userId)
				.memberSt(memberSt)
				.fromDt(fromDt)
				.build();
	}

}
