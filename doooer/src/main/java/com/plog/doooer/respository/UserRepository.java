package com.plog.doooer.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plog.doooer.domain.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	//public UserEntity findByEmail(String email);
	// Optional<UserEntity> findByEmail(String userEmail);
	UserEntity findByEmail(String userEmail);

}
