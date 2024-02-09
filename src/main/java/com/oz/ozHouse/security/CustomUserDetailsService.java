package com.oz.ozHouse.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Log4j2
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService{
	/*
	[UserDetailService]
	스프링 시큐리티에서 가장 중요한 객체는 실제로 인증을 처리하는 : UserDetailService 라는 인터페이스의 구현체 
	UserDetail interface 는 loadUserByUsername 이라는 단 하나의 메소드를 가지는데,
	해당 메서드가 실제로 인증을 처리할 때 호출되는 부분이다.
	
	실제 개발 작업은 UserDetailService 인터페이스를 구현해서 
	username이라고 부르는 사용자의 아이디 인증을 코드로 구현하는 것이다
	
	[반환 타입 UserDetails?]
	loadUserByUsername() 의 반환 타입은 org.springframework.security.core.userdetails 패키지의
	UserDetails 라는 인터페이스 타입으로 지정되어 있습니다. 
	UserDetail 는 사용자 인증과 관련된 정보들을 저장하는 역할을 합니다.
	스프링 시큐리티는 내부적으로 UserDetails 타입의 객체를 이용해서 패스워드를 검사하고,
	사용자 권한을 확인하는 방식으로 동작합니다.
	
	getAuthorities() 메소드는 사용자가 가진 모든 인가(Authority) 정보를 반환한다.
	
	개발 단계에서 UserDetails 라는 인터페이스 타입에 맞는 객체가 필요하고 
	이를 CustomUserDetailsService 에서 반환하는 일이 필요하다.	
	*/
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		log.info("loadUserByUsername : " + username);
		
		UserDetails userDetails = User.builder()
				.username("user1")
				.password("1111")
				.authorities("ROLE_USER")
				.build();
		
		
		return null;
	}
}
