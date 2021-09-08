package com.plog.doooer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plog.doooer.domain.JobEntity;
import com.plog.doooer.domain.RecruitmentEntity;

public interface JobRepository extends JpaRepository<JobEntity, Long> {

//	JobEntity getByRctEntityAndJobGrpCd(RecruitmentEntity rctEntity, String jobGrpCd);

}
