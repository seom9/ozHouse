package com.oz.ozHouse.client.security;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.oz.ozHouse.client.repository.MemberRepository;
import com.oz.ozHouse.domain.Member;
import com.oz.ozHouse.domain.common.MemberLevel;
import com.oz.ozHouse.domain.common.MemberRole;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService{
	
	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder;
	
	// DefaultOAuth2UserService
	// Spring Security에서 OAuth2 사용자 정보를 가져오는 데 사용되는 기본 서비스
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		ClientRegistration clientRegistration = userRequest.getClientRegistration();
		String clientName = clientRegistration.getClientName();
		
		OAuth2User oAuth2User = super.loadUser(userRequest);
		Map<String, Object> paramMap = oAuth2User.getAttributes();
		
		String email = null;
		
		switch (clientName) {
			case "kakao" : 
				email = getKakaoEmail(paramMap);
				break;
		}
		
		return generateDTO(email, paramMap);
	}
	
	private MemberSecurityDTO generateDTO(String email, Map<String, Object> params) {
		
		Optional<Member> result = memberRepository.findByMemberEmail(email);
		
		if(result.isEmpty()) { // new 이메일 ? 새 계정 생성
			Member member = Member.builder()
					.memberId(email)
					.memberPasswd(passwordEncoder.encode("1111"))
					.social(true)
					.memberEmail(email)
	                .memberPoint(0)
	                .memberLevel(MemberLevel.NORMAL)
					.build();
			member.addRole(MemberRole.CLIENT);
			memberRepository.save(member);
			
			//MemberSecurityDTO 구성 및 반환
			MemberSecurityDTO memberSecurityDTO = gernerateConsDTO(member);
			// builder 로 props 따로 설정
			memberSecurityDTO = memberSecurityDTO.props(params);
			
			return memberSecurityDTO;
		}else {	// old 이메일 ? 소셜 회원인지 아닌지 확인
			Member member = result.get();
			
			// 소셜 회원으로 되어 있지 않을 경우 social 회원으로 업데이트
			if (member.isSocial() == false) 
				memberRepository.updateSocialStatusByMemberId(member.getMemberId());
			
			//MemberSecurityDTO 구성 및 반환
			MemberSecurityDTO memberSecurityDTO = gernerateConsDTO(member);
			return memberSecurityDTO;
		}
	}
	
	private MemberSecurityDTO gernerateConsDTO (Member member) {
		MemberSecurityDTO memberSecurityDTO =
				new MemberSecurityDTO(
						member.getMemberNum(),
						member.getMemberId(),
						member.getMemberPasswd(),
						member.getMemberEmail(),
						member.getMemberNickname(),
						member.getMemberDeletedate(),
						member.isSocial(),
						member.getRoleSet()
								.stream().map(memberRole -> new SimpleGrantedAuthority("ROLE_" + memberRole.name())).collect(Collectors.toList())
								);
		return memberSecurityDTO;
	}
	
	private String getKakaoEmail(Map<String, Object> paramMap) {
		Object value = paramMap.get("kakao_account");
		LinkedHashMap accountMap = (LinkedHashMap) value;
		String email = (String) accountMap.get("email");
		return email;
	}
	

}
