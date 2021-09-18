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

import com.plog.doooer.domain.UserEntity;
import com.plog.doooer.respository.UserRepository;
import com.plog.doooer.util.JwtUtil;

import common.PlogException;
import common.PlogExceptionEnum;

@Service
public class UserService implements UserDetailsService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;

	@Transactional
	public String signup(SignupRequestDTO signupRequestDTO)  {
		
		try {
			UserEntity user = signupRequestDTO.toEntity();
			
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			
			//user.setPassword(passwordEncoder.encode(signupRequestDTO.getPassword()));
			//user.setCreatedDt(LocalDateTime.now());
			//user.setAuth("MEMBER");
			
			user.updatePassword(passwordEncoder.encode(signupRequestDTO.getPassword()));
			user.updateCreatedDt(LocalDateTime.now());			
			user.updateAuth("MEMBER");
			
			userRepository.save(user);
		} catch (Exception e) {
			e.printStackTrace();
			
			return "ERROR";
		}
		
		return "SUCCESS";
	}
	
	public UserEntity getUserInfo(String token)  {
		String userEmail = jwtUtil.extractUsername(token);
		UserEntity userEntity = userRepository.findAllByEmail(userEmail);
	
		return userEntity;
	}
	
	@Override
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findByEmail(userEmail);
		
		if (userEntity == null) {
			throw new PlogException(PlogExceptionEnum.SECURITY_02);
		}
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		authorities.add(new SimpleGrantedAuthority(userEntity.getAuth()));
		
		return new User(userEntity.getEmail(), userEntity.getPassword(), authorities);
		//return new User(userEntity.getEmail(), userEntity.getPw(), new ArrayList<>());
	}
	
	public String generateToken(LoginRequestDTO loginRequestDTO) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequestDTO.getUserName(), loginRequestDTO.getPassword())
			);
		} catch (Exception ex) {
			//throw new Exception("inavalid username/password");
			throw new PlogException(PlogExceptionEnum.SECURITY_02);
		}
		
		return jwtUtil.generateToken(loginRequestDTO.getUserName());
	}
}
