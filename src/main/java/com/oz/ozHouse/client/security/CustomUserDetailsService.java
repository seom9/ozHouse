package com.oz.ozHouse.client.security;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.oz.ozHouse.client.repository.MemberRepository;
import com.oz.ozHouse.domain.Member;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService{
	private final MemberRepository memberRepository;
	
	@Override
	public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException{
		// UserDetails 의 인터페이스를 구현한 user 객체로 유저의 객체를 만들 수 있다
		Optional<Member> result = memberRepository.getWithRole(memberId);
		
		if (result.isEmpty()) {	// 해당 아이디를 가진 사람이 없다면?
			throw new UsernameNotFoundException("username no found....");
		}
		
		Member member = result.get();
		
		// 새로운 MemberSecurityDTO 만들어 주기
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
