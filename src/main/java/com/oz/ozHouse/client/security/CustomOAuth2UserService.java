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
		
		// 데이터 베이스에 해당 이메일 사용자가 없다면
		if(result.isEmpty()) {
			// 회원 추가 : memberId 는 이메일 주소
			Member member = Member.builder()
					.memberId(email)
					.memberPasswd(passwordEncoder.encode("1111"))
					.social(true)
	                .memberPoint(0)
	                .memberLevel(MemberLevel.NORMAL)
					.build();
			member.addRole(MemberRole.CLIENT);
			memberRepository.save(member);
			
			//MemberSecurityDTO 구성 및 반환
			MemberSecurityDTO memberSecurityDTO = 
					new MemberSecurityDTO(email, "1111", email, email, null, true, Arrays.asList(new SimpleGrantedAuthority("ROLE_CLIENT")));
			memberSecurityDTO = memberSecurityDTO.props(params);
			return memberSecurityDTO;
		}else {
			Member member = result.get();
			System.out.println("첫 번째 :" + member.getMemberId());

			member.social(true);
			memberRepository.save(member); // 소셜 회원으로 업데이트
			
			System.out.println("두 번째 :" + member.getMemberId());
			
			MemberSecurityDTO memberSecurityDTO =
					new MemberSecurityDTO(
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
	}
	
	private String getKakaoEmail(Map<String, Object> paramMap) {
		Object value = paramMap.get("kakao_account");
		LinkedHashMap accountMap = (LinkedHashMap) value;
		String email = (String) accountMap.get("email");
		return email;
	}
	
//	loadUser() 메서드는 OAuth2UserRequest 객체를 매개변수로 받아들이고, 
//	이를 처리하여 OAuth2User 객체를 반환합니다. 
	
//	먼저, userRequest 객체에서 OAuth2 클라이언트 등록 정보(ClientRegistration)를 가져옵니다. 
//	이 정보를 사용하여 클라이언트의 이름을 얻을 수 있습니다.

//	이 메서드는 부모 클래스인 DefaultOAuth2UserService의 loadUser() 메서드를 호출하여 
//	실제로 OAuth2 사용자 정보를 가져옵니다. 
//	필요에 따라 이 메서드를 오버라이드하여 사용자 정보를 커스터마이징할 수 있습니다.
	
// 	LickedHashMap
//	삽입 순서 또는 액세스 순서를 기반으로 요소들을 유지
//	내부적으로 해시 테이블과 연결 리스트를 사용하여 요소들을 저장하며, 이 때 연결 리스트는 요소들의 삽입 순서나 액세스 순서를 기억
//	순서 유지: 요소들을 삽입한 순서대로 유지합니다.
//	액세스 순서 유지: 요소들에 대한 액세스 순서를 유지할 수 있습니다. 액세스 순서를 유지하도록 생성자를 호출할 수 있으며, 
//	이 때 가장 최근에 액세스한 요소가 가장 뒤쪽으로 이동합니다.
}
