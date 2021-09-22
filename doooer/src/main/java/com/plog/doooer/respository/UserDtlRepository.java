package com.plog.doooer.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plog.doooer.domain.UserDtlEntity;
import com.plog.doooer.domain.UserEntity;

@Repository
public interface UserDtlRepository extends JpaRepository<UserDtlEntity, Long> {
	UserDtlEntity findAllById(long id);
//	UserDtlEntity findAllByEmail(String userEmail);
}
