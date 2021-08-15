package com.plog.doooer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.plog.doooer.Filter.JwtAuthenticationFilter;
import com.plog.doooer.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService);
		
	}
	
	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	/*
	 * login, register를 제외한 모든 요청은 인증이 필요함.
	 * */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
			//.antMatchers("/api/authenticate").permitAll()
			.antMatchers("/api/signup").permitAll() 
			.antMatchers("/api/login").permitAll()
			.anyRequest().authenticated()
			.and().exceptionHandling()
			.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
	}

	/* 제외 패턴 */
//	@Override
//	public void configure(WebSecurity web) {
//		//web.ignoring().antMatchers("/css/**", "/js/**", "/img/**");
//        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**");
//	}
	/* 패턴 등록 */
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable().authorizeRequests() // 페이지 권한 설정
//				.antMatchers("/api/login").permitAll()
//				.anyRequest().hasRole("MEMBER")
//				.and() // 로그인 설정
//				.formLogin().loginPage("/api/login").defaultSuccessUrl("/api/userInfo")
//				.loginProcessingUrl("/doLogin")//loginPage("/api/login")...permitAll()//.permitAll() .defaultSuccessUrl("/api/loginResult")//.permitAll()
//				.and()
//				//.logout().logoutRequestMatcher(new AntPathRequestMatcher("/api/logout")) // 로그아웃
//				//.logoutSuccessUrl("/api/logout/result").invalidateHttpSession(true)
//				//.and() // 403 예외처리 핸들링
//				//.exceptionHandling().accessDeniedPage("/user/denied");
//				;
//	}
	
	/* 인증 */
//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
//	}
}