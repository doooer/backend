package com.plog.doooer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plog.doooer.domain.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
	
}
