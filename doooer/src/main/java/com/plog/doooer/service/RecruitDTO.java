package com.plog.doooer.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import org.springframework.data.annotation.LastModifiedDate;

import com.plog.doooer.domain.JobEntity;
import com.plog.doooer.domain.RecruitmentEntity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RecruitDTO {
	//모집글부
	//프로젝트 정보 - 각각의 변수
	private long id; //모집글ID

	private long userId;

	private String title;

	private String content;
	private String onlineYn;
	private String rctRgnCd;
	private String prjCateCd;
	private String keyword; //주제 등 복합 작성. 구분자로 ',' 사용
	private String step; //팀 진행 단계?. ex)아이디어 구상 단계, 기획 단계, 초기 개발 단계 등...
	private String conEmail;
	private String conHp;
	private String openChatUrl;
	private String rctImg;
	private Date createdDt;
	private Date updatedDt;
	
	//모집직군은 리스트
	private List<JobDTO> jobs = new ArrayList<JobDTO>();
	
	//팀정보부
	//팀정보
	private TeamDTO team;
	//멤버정보는 리스트
	private List<MemberDTO> members = new ArrayList<MemberDTO>();
//	private long teamId;
//	private String teamNm; //팀 이름
//	private String teamImg; //팀 로고이미지
//	private String teamInfo; //팀 정보
//	private Date fromDt; //팀 결성일 = 모집 시작일. 모든 직군의 모집이 마감되는 경우 결성일 생성.
//	private Date toDt; //팀 종료일 = 프로젝트 종료일 또는 팀 포트폴리오 작성일. 포트폴리오 작성 시 종료일 생성?
	
	RecruitmentEntity toRctEntity() {
		return RecruitmentEntity.builder()
				.id(id)
				.userId(userId)
				.title(title)
				.content(content)
				.onlineYn(onlineYn)
				.rctRgnCd(rctRgnCd)
				.prjCateCd(prjCateCd)
				.keyword(keyword)
				.step(step)
				.conEmail(conEmail)
				.conHp(conHp)
				.openChatUrl(openChatUrl)
				.rctImg(rctImg)
				.createdDt(createdDt)
				.updatedDt(updatedDt)
				.build();
	}
	
//	List<JobEntity> toJobEntityList(List<JobDTO> dtoList){
//		List<JobEntity> jobEntityList = new ArrayList<JobEntity>();
//		
//		for(JobDTO dto : dtoList) {
//			JobEntity job = dto.toEntity();
//			jobEntityList.add(job);
//		}
//		
//		return jobEntityList;
//	}
	
//	TeamDTO toTeamDTO() {
//		TeamDTO dto = new TeamDTO();
//		
//	}
	

}