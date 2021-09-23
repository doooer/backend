package com.plog.doooer.controller;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plog.doooer.domain.MemberEntity;
import com.plog.doooer.domain.RecruitmentEntity;
import com.plog.doooer.domain.TeamEntity;
import com.plog.doooer.service.JobDTO;
import com.plog.doooer.service.MemberDTO;
import com.plog.doooer.service.RecruitDTO;
import com.plog.doooer.service.RecruitService;
import com.plog.doooer.service.RecruitmentDTO;
import com.plog.doooer.service.RecruitmentService;
import com.plog.doooer.service.TeamDTO;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/recruitment")
public class RecruitmentController {
//	@Autowired
//	RecruitmentService recruitmentService;
	@Autowired
	RecruitService recruitService;
	
//	@RequestMapping("/save-tmp")
//	@ApiOperation(value = "모집 임시 저장", notes = "모집 공고를 임시로 저장한다.")
//	@ApiImplicitParams({
//		@ApiImplicitParam(name = "writer", value = "작성자", required = true, defaultValue = "1234@doooer.io")
//		, @ApiImplicitParam(name = "rctSt", value = "모집상태", required = true, defaultValue = "00")
//		, @ApiImplicitParam(name = "title", value = "제목", required = false, defaultValue = "A공모전 팀 모집글 제목/한 줄 요약")
//		, @ApiImplicitParam(name = "content", value = "모집내용", required = false, defaultValue = "A공모전 팀 모집글 내용")
//		, @ApiImplicitParam(name = "fromDt", value = "모집시작일", required = false)
//		, @ApiImplicitParam(name = "toDt", value = "모집마감일", required = false)
//		, @ApiImplicitParam(name = "rctRgnCd", value = "모집지역", required = false, defaultValue = "서울")
//		, @ApiImplicitParam(name = "keyword", value = "키워드", required = false, defaultValue = "반려동물")
//		, @ApiImplicitParam(name = "step", value = "팀 진행단계", required = false)
//		, @ApiImplicitParam(name = "openChatUrl", value = "오픈채팅URL", required = false)
//	})
//	public String saveRecruitmentTmp(RecruitmentDTO dto) {
//		System.out.println(dto.toString());
//		return recruitmentService.saveRecruitmentTmp(dto);
//	}
	
//	@RequestMapping("/id")
//	@ApiOperation(value = "단건 조회(상세)", notes = "모집글 상세 내용을 조회한다.")
//	@ApiImplicitParam(name = "id", value = "게시글ID", required = true, defaultValue = "0")
//	public String findRecruitmentById(long recruitId) {
//		return recruitmentService.findOneByRecruitId(recruitId).toString();
//	}
	
//	@RequestMapping("/writer")
//	@ApiOperation(value = "작성자 검색", notes = "모집글을 작성자로 조회한다.")
//	@ApiImplicitParam(name = "writer", value = "작성자", required = true, defaultValue = "1234@doooer.io")
//	public String findRecruitmentsByWriter(String writer) {
//		return recruitmentService.findListByWriter(writer).toString();
//	}
//	
//	@RequestMapping("/status")
//	@ApiOperation(value = "글상태 검색", notes = "모집글을 글 작성 상태로 조회한다.")
//	@ApiImplicitParam(name = "writer", value = "작성자", required = true, defaultValue = "00")
//	public String findRecruitmentsByRecruitSt(String recruitSt) {
//		return recruitmentService.findListByRecruitSt(recruitSt).toString();
//	}
	
//	@RequestMapping("/title")
//	@ApiOperation(value = "글 제목 검색", notes = "모집글을 글 제목으로 조회한다.")
//	@ApiImplicitParam(name = "title", value = "제목")
//	public String findRecruitmentsByTitle(String title) {
//		return recruitmentService.findListByTitle(title).toString();
//	}
	@RequestMapping("/list")
	@ApiOperation(value = "모집글 리스트 조회", notes = "모집글 리스트를 조회함.")
	public List<RecruitDTO> findRctList() {
		return recruitService.getRctList();
	}
	
	@RequestMapping("/save")
	@ApiOperation(value = "모집글 게시", notes = "모집글 게시(임시저장x)")
//	@ApiImplicitParams({
//		@ApiImplicitParam(name = "userId", value = "작성자", required = true, defaultValue = "admin@doooer.io")
//		,@ApiImplicitParam(name = "title", value = "모집글 제목", required = true, defaultValue = "두두어 프로젝트 모집합니다.")
//		,@ApiImplicitParam(name = "onlineYn", value = "모집글 내용", required = true, defaultValue = "두두를 두루미로 진화시키는 프로젝트입니다.")
//		,@ApiImplicitParam(name = "rctRgnCd", value = "모집 지역", required = true, defaultValue = "RG04")
//		,@ApiImplicitParam(name = "prjCateCd", value = "프로젝트 카테고리", required = true, defaultValue = "CA10")
//		,@ApiImplicitParam(name = "keyword", value = "프로젝트 키워드", required = true, defaultValue = "두두,두루미,진화")
//		,@ApiImplicitParam(name = "step", value = "팀 진행 단계", required = true, defaultValue = "ST01")
//		,@ApiImplicitParam(name = "conEmail", value = "연락할 이메일", required = true, defaultValue = "admin@doooer.io")
//		
//		,@ApiImplicitParam(name = "jobGrpCd", value = "모집직군", required = true, defaultValue = "JB30")
//		,@ApiImplicitParam(name = "jobCd1", value = "모집직무", required = true, defaultValue = "JB33")
//		,@ApiImplicitParam(name = "jobFromDt", value = "모집시작일", required = true, defaultValue = "2021-08-24")
//		,@ApiImplicitParam(name = "jobToDt", value = "모집종료일", required = true, defaultValue = "2021-08-31")
//		,@ApiImplicitParam(name = "rctSt", value = "모집상태", required = true, defaultValue = "RS01")
//		,@ApiImplicitParam(name = "rctPrsnlCnt", value = "모집인원", required = true, defaultValue = "3")
//		,@ApiImplicitParam(name = "jobContent", value = "연락할 이메일", required = true, defaultValue = "아아 백개발자 구합니다~~")
//		
//		,@ApiImplicitParam(name = "teamNm", value = "연락할 이메일", defaultValue = "두두루미루두두")
//		,@ApiImplicitParam(name = "teamInfo", value = "연락할 이메일", defaultValue = "햅삐하게 두루미를 진화시킵시다.")
//		
//		,@ApiImplicitParam(name = "memberUserId", value = "멤버아이디", defaultValue = "1")
//		,@ApiImplicitParam(name = "memberSt", value = "참여상태", defaultValue = "MS01")
//		,@ApiImplicitParam(name = "fromDt", value = "참여시작일", defaultValue = "2021-08-24")
//		
//	})
	public String saveRct(@RequestBody RecruitDTO rctDto) {
		return recruitService.saveRct(rctDto);
	}
}
