package com.plog.doooer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Table(name = "TB_APPLICATION")
@Entity
@Data
@RequiredArgsConstructor
public class ApplicationEntity {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	private RecruitmentEntity rctEntity; //얘 pk로도 쓰고 싶은데요... 복합키 잘 안쓰나?

	@Column(name = "USER_ID")
	private long userId;
	
	@Column(name = "JOB_GRP_CD", length = 4)
	private String jobGrpCd;
	
	@Column(name = "ACCEPT_ST", length = 1)
	private String acceptSt;
	
	@Column(name = "APPLY_RSN")
	private String applyRsn;
}
