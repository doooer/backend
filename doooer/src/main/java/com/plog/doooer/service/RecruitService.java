package com.plog.doooer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plog.doooer.domain.JobEntity;
import com.plog.doooer.domain.MemberEntity;
import com.plog.doooer.domain.RecruitmentEntity;
import com.plog.doooer.domain.TeamEntity;
import com.plog.doooer.repository.ApplicationRepository;
import com.plog.doooer.repository.JobRepository;
import com.plog.doooer.repository.MemberRepository;
import com.plog.doooer.repository.RecruitmentRepository;
import com.plog.doooer.repository.TeamRepository;

@Service
public class RecruitService {
	@Autowired
	RecruitmentRepository recruitmentRepository;
	
	@Autowired
	JobRepository jobRepository;
	
	@Autowired
	ApplicationRepository applicationRepository;
	
	@Autowired
	TeamRepository teamRepository;
	
	@Autowired
	MemberRepository memberRepository;
	
//	//단건 조회 - 상세
//	public void getRctDetail(long rctId, String jobGrpCd) {
//		RecruitmentEntity rct = recruitmentRepository.getById(rctId);
//		JobEntity job = jobRepository.getByJobGrpCd(rct, jobGrpCd);
//		
//		System.out.println(job);
////		return result;
//	}
	
	//다건 조회 - 목록
	public List<RecruitDTO> getRctList() {
		List<RecruitDTO> resultList = new ArrayList<RecruitDTO>();
		List<RecruitmentEntity> entityList = recruitmentRepository.findAll();
		
		for(RecruitmentEntity entity : entityList) {
			RecruitDTO rct = entity.toDto();
			resultList.add(rct);
		}
		
		System.out.println(resultList);
		return resultList;
	}
	
	//저장
	public String saveRct(RecruitDTO rctDto) {
		try {
			RecruitmentEntity rct = recruitmentRepository.save(rctDto.toRctEntity());
//			rctDto.
			try {
				for(JobDTO jobDto :  rctDto.getJobs()) {
					JobEntity jobEntity = jobDto.toEntity();
					jobEntity.setRctEntity(rct);
					jobRepository.save(jobEntity);
				}
				try {
					TeamEntity teamEntity = rctDto.getTeam().toEntity();
					teamEntity.setRctEntity(rct);
					TeamEntity team = teamRepository.save(teamEntity);
					try {
						for(MemberDTO memberDto : rctDto.getMembers()) {
							MemberEntity memberEntity = memberDto.toEntity();
							memberEntity.setTeamEntity(team);
							memberRepository.save(memberEntity);			
						}
						return "모두 성공!";
					}catch(Exception e) {
						e.printStackTrace();
						
						return "Member 실패";
					}
				} catch(Exception e ) {
					e.printStackTrace();
					return "Team 실패";
				}
			} catch(Exception e) {
				e.printStackTrace();
				recruitmentRepository.delete(rctDto.toRctEntity());
				return "Job 실패";
			}
		} catch(Exception e) {
			e.printStackTrace();
			return "recruitment 실패";
		}
	}
}
