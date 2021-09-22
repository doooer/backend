package com.plog.doooer.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.plog.doooer.common.PlogException;
import com.plog.doooer.common.PlogExceptionEnum;
import com.plog.doooer.domain.UserDtlEntity;
import com.plog.doooer.domain.UserEntity;
import com.plog.doooer.respository.UserDtlRepository;
import com.plog.doooer.respository.UserRepository;
import com.plog.doooer.util.JwtUtil;

@Service
public class UserService implements UserDetailsService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserDtlRepository userDtlRepository;
	
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;

	@Transactional
	public void signup(SignupRequestDTO signupRequestDTO) {
		
		try {
			UserEntity user = signupRequestDTO.toEntity();
			UserDtlEntity userDtl = new UserDtlEntity();
			
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			
			user.updatePassword(passwordEncoder.encode(signupRequestDTO.getPassword()));
			user.updateCreatedDt(LocalDateTime.now());			
			user.updateAuth("MEMBER");
			userRepository.save(user);
			
			userDtl.setId(userRepository.findIdByEmail(user.getEmail()).getId());
			userDtlRepository.save(userDtl);
		} catch (Exception e) {
			throw new PlogException(PlogExceptionEnum.UPDATE_01);
		}
	}
	
	@Transactional
	public void updateUserInfo(UpdateUserInfoRequestDTO updateUserInfoRequestDTO ) {
		
		UserDtlEntity userDtl = userDtlRepository.findAllById(updateUserInfoRequestDTO.getId());
		UserEntity user = userRepository.findAllById(updateUserInfoRequestDTO.getId());
		
		try {
			user.updateName(updateUserInfoRequestDTO.getName());
			user.updatePrflImgId(updateUserInfoRequestDTO.getPrflImgId());
			user.updateJobCd(updateUserInfoRequestDTO.getJobCd());
			user.updateIntroduce(updateUserInfoRequestDTO.getIntroduce());

			userRepository.save(user);
			
			userDtl.updateOpenChatUrl(updateUserInfoRequestDTO.getOpenChatUrl());
			userDtl.updateRefLink(updateUserInfoRequestDTO.getRefLink());
			userDtl.updateRefLink2(updateUserInfoRequestDTO.getRefLink2());
			userDtl.updateEducationList(updateUserInfoRequestDTO.getEducationList());
			userDtl.updateCertificateList(updateUserInfoRequestDTO.getCertificateList());
			userDtl.updateAwardList(updateUserInfoRequestDTO.getAwardList());
			userDtl.updateUseTech(updateUserInfoRequestDTO.getUseTech());
			
			userDtlRepository.save(userDtl);
		} catch (Exception e) {
			throw new PlogException(PlogExceptionEnum.UPDATE_01);
		}
	}
	
	public UserEntity getUserInfo(String token)  {
		String userEmail;
		UserEntity userEntity;
		
		try {
			userEmail = jwtUtil.extractUsername(token);
			userEntity = userRepository.findAllByEmail(userEmail);
		} catch (Exception e) {
			throw new PlogException(PlogExceptionEnum.SELECT_01);
		}
		
		return userEntity;
	}
	
	public UserDtlEntity getUserDtlInfo(String token)  {
		
		String userEmail;
		UserEntity userEntity;
		UserDtlEntity userDtlEntity;
		
		try {
			userEmail = jwtUtil.extractUsername(token);
			userEntity = userRepository.findAllByEmail(userEmail);
			userDtlEntity = userDtlRepository.findAllById(userEntity.getId());
		} catch (Exception e) {
			throw new PlogException(PlogExceptionEnum.SELECT_01);
		}
		
	
		return userDtlEntity;
	}
	
	@Override
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findByEmail(userEmail);
		
		if (userEntity == null) {
			throw new PlogException(PlogExceptionEnum.LOGIN_01);
		}
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		authorities.add(new SimpleGrantedAuthority(userEntity.getAuth()));
		
		return new User(userEntity.getEmail(), userEntity.getPassword(), authorities);
	}
	
	public String generateToken(LoginRequestDTO loginRequestDTO) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequestDTO.getUserName(), loginRequestDTO.getPassword())
			);
		} catch (Exception ex) {
			throw new PlogException(PlogExceptionEnum.LOGIN_01);
		}
		
		return jwtUtil.generateToken(loginRequestDTO.getUserName());
	}
}
