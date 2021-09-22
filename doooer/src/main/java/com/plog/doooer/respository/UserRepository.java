package com.plog.doooer.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plog.doooer.domain.UserDtlEntity;
import com.plog.doooer.domain.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findByEmail(String userEmail);
	UserEntity findAllByEmail(String userEmail);
	UserEntity findIdByEmail(String userEmail);
	UserEntity findAllById(long id);
}
