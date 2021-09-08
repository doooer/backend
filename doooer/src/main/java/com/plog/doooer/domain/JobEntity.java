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

@Table(name = "TB_JOB")
@Entity
@Data
@RequiredArgsConstructor
public class JobEntity {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	//단방향? 양방향. 얘가 fk주인.
	@ManyToOne
	private RecruitmentEntity rctEntity;
	
	//직군
	@Column(name = "JOB_GRP_CD", length = 4)
	private String jobGrpCd;

	//직무 값
	@Column(name = "JOB_CD1", length = 4)
	private String jobCd1;
	
	//직무 값
	@Column(name = "JOB_CD2", length = 4)
	private String jobCd2;
	
	//직무 값
	@Column(name = "JOB_CD3", length = 4)
	private String jobCd3;
	
	@Column(name = "FROM_DT")
	private Date fromDt;
	
	@Column(name = "TO_DT")
	private Date toDt;
	
	@Column(name = "RCT_ST", length = 4, nullable = false)
	private String rctSt;
	
	@Column(name = "RCT_PRSNL_CNT")
	private int rctPrsnlCnt;
	
	@Column(name = "KEYWORD")
	private String keyword;

	@Column(name = "CONTENT")
	private String content;
	

	@Builder
	public JobEntity(String jobGrpCd, String jobCd1, String jobCd2, String jobCd3, Date fromDt, Date toDt, String rctSt, int rctPrsnlCnt, String keyword, String content) {
		super();
//		this.rctId = rctId;
		this.jobGrpCd = jobGrpCd;
		this.jobCd1 = jobCd1;
		this.jobCd2 = jobCd2;
		this.jobCd3 = jobCd3;
		this.fromDt = fromDt;
		this.toDt = toDt;
		this.rctSt = rctSt;
		this.rctPrsnlCnt = rctPrsnlCnt;
		this.keyword = keyword;
		this.content = content;
	}
	
//	public JobDTO toDto() {
//		return JobDTO.builder()
//				.rctId(rctId)
//				.jobCd(jobCd)
//				.rctCnt(rctCnt)
//				.rctSt(rctSt)
//				.content(content)
//				.keyword(keyword)
//				.build();
//	}
	
}
