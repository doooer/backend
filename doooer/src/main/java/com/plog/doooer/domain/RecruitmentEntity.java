package com.plog.doooer.domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.LastModifiedDate;

import com.plog.doooer.service.RecruitDTO;
import com.plog.doooer.service.RecruitmentDTO;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Table(name = "TB_RECRUITMENT")
@Entity
@Data
@RequiredArgsConstructor
public class RecruitmentEntity {
	
//	@OneToMany(mappedBy = "RCT_ID")
//	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinColumn()
//	private JobEntity job;

//	@Column(name = "RCT_ST", length = 4, nullable = false)
//	private String rctSt; //모집글 상태. 예) 작성중, 모집중, 모집종료 등. TB_CODE에서 코드 값으로 관리할 예정  -> 모집직군으로 이동
	
	//모집글 테이블 컬럼
	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)//AI
	private long id; //모집글ID
	
	@Column(name = "USER_ID", length = 40, nullable = false)
	private long userId;
	
	@Column(name = "TITLE", length = 200)
	private String title;
	
	@Column(name = "CONTENT", length = 200)
	private String content;
	
	@Column(name = "ONLINE_YN", length = 1)
	private String onlineYn;
	
	@Column(name = "RCT_RGN_CD", length = 40) //시단위
	private String rctRgnCd;
	
	@Column(name = "PRJ_CATE_CD")
	private String prjCateCd;
	
	@Column(name = "KEYWORD")
	private String keyword; //주제 등 복합 작성. 구분자로 ',' 사용
	
	@Column(name = "STEP")
	private String step; //팀 진행 단계?. ex)아이디어 구상 단계, 기획 단계, 초기 개발 단계 등...
	
	@Column(name = "CON_EMAIL", length = 40)
	private String conEmail;
	
	@Column(name = "CON_HP", length = 11)
	private String conHp;
	
	@Column(name = "OPEN_CHAT_URL")
	private String openChatUrl;
	
	@Column(name = "RCT_IMG")
	private String rctImg;
	
	//최초 자동입력하고 게시일 따로 관리해야 하나? 워째야 하는감...
	@Column(name = "CREATED_DT")
	private Date createdDt;
	
	@Column(name = "UPDATED_DT")
	@LastModifiedDate
	private Date updatedDt;
	
	//양방향? 단방향!
	@OneToMany
	@JoinColumn(name = "ID")
	@ToString.Exclude
	private Collection<JobEntity> jobEntity;
	
	//단방향
	@OneToMany
	@JoinColumn(name = "ID")
	@ToString.Exclude
	private Collection<ApplicationEntity> applications;
	
	//양방향?
	@OneToOne
	@JoinColumn(name = "ID")
	@ToString.Exclude
	private TeamEntity team;

	@Builder
	public RecruitmentEntity(JobEntity job, Collection<ApplicationEntity> applications, long id, String rctSt, long userId, String title,
			String content, String onlineYn, Date fromDt, Date toDt, String rctRgnCd, String prjCateCd, String keyword, String step,
			String conEmail, String conHp, String openChatUrl, String rctImg, Date createdDt, Date updatedDt) {
		super();
//		this.job = job;
//		this.applications = applications;
//		this.team = team;
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.onlineYn = onlineYn;
		this.rctRgnCd = rctRgnCd;
		this.prjCateCd = prjCateCd;
		this.keyword = keyword;
		this.step = step;
		this.conEmail = conEmail;
		this.conHp = conHp;
		this.openChatUrl = openChatUrl;
		this.rctImg = rctImg;
		this.createdDt = createdDt;
		this.updatedDt = updatedDt;
	}

	public RecruitDTO toDto() {
		return RecruitDTO.builder()
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
	
}
