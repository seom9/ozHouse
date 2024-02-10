package com.oz.ozHouse.security;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.oz.ozHouse.client.repository.MemberRepository;
import com.oz.ozHouse.domain.Member;
import com.oz.ozHouse.dto.client.member.MemberSecurityDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Log4j2
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService{
	private final MemberRepository memberRepository;

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
	
	/*
	스프링 시큐리티는 기본적으로 Password Encoder 라는 존재를 필요로 하며, 
	BcryptPasswordEncoder 는 해시 알고리즘으로 암호화 처리되는데 같은 문자열이라도 매번
	해시 처리된 결과가 다르므로 패스워드 암호화에 많이 사용된다

	 */
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		
		// UserDetails 의 인터페이스를 구현한 user 객체로 유저의 객체를 만들 수 있다
		Optional<Member> result = memberRepository.getWithRole(username);
		
		if (result.isEmpty()) {	// 해당 아이디를 가진 사람이 없다면?
			throw new UsernameNotFoundException("username no found....");
		}
		
		Member member = result.get();
		
		MemberSecurityDTO memberSecurityDTO = 
				new MemberSecurityDTO (
						member.getMemberNum(),
						member.getMemberId(),
						member.getMemberPasswd(),
						member.getMemberNickname(),
						member.getMemberEmail(),
						member.getMemberDeletedate(),
						false,
						member.getRoleSet()
								.stream().map(memberRole -> new SimpleGrantedAuthority("ROLE_"+memberRole.name()))
								.collect(Collectors.toList())
						);
		
		return memberSecurityDTO;
	}
}
