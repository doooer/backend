package com.plog.doooer.service;

import java.util.Date;

import javax.persistence.Column;

import com.plog.doooer.domain.JobEntity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
public class JobDTO {
	private long rctId;
	private String jobGrpCd;
	private String jobCd1;
	private String jobCd2;
	private String jobCd3;
	private Date fromDt;
	private Date toDt;
	private String rctSt;
	private int rctPrsnlCnt;
	private String keyword;
	private String content;
	
	
	public JobEntity toEntity() {
		return JobEntity.builder()
				.jobGrpCd(jobGrpCd)
				.jobCd1(jobCd1)
				.jobCd2(jobCd2)
				.jobCd2(jobCd2)
				.fromDt(fromDt)
				.toDt(toDt)
				.rctSt(rctSt)
				.rctPrsnlCnt(rctPrsnlCnt)
				.keyword(keyword)
				.content(content)
				.build();
	}
	
}
