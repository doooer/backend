package com.plog.doooer.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Table(name = "TB_MEMBER")
@Entity
@Data
@RequiredArgsConstructor
public class MemberEntity {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	private TeamEntity teamEntity;
	
	@Column(name = "USER_ID")
	private long userId;
	
	@Column(name = "MEMBER_ST")
	private String memberSt; //멤버 상태. 예) 참여중, 중도이탈? 등
	
	@Column(name = "FROM_DT")
	private Date fromDt;

	@Builder
	public MemberEntity(TeamEntity teamEntity, long userId, String memberSt, Date fromDt) {
		super();
		this.teamEntity = teamEntity;
		this.userId = userId;
		this.memberSt = memberSt;
		this.fromDt = fromDt;
	}
	
	

}
