package com.oz.ozHouse.client.security;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.core.user.OAuth2User;

import lombok.Getter;

@Getter
public class MemberSecurityDTO extends User implements OAuth2User {
	private int memberNum;
	private String memberId;
	private String memberPasswd;
    private String memberNickname;
    private String memberEmail;
    private LocalDate memberDeleteDate;
    private boolean social;
    
    private Map<String, Object> props; 	// 소셜 로그인 정보
    
    public MemberSecurityDTO(int memberNum, String username, String password, 
    						String memberNickname, String memberEmail, 
    						LocalDate memberDeleteDate, boolean social,
    						Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.memberNum = memberNum;
        this.memberId = username;
        this.memberPasswd = password;
        this.memberNickname = memberNickname;
        this.memberEmail = memberEmail;
        this.memberDeleteDate = memberDeleteDate;
        this.social = social;
    }
    
    public MemberSecurityDTO props(Map<String, Object> props) {
        this.props = props;
        return this;
    }
    
    // OAuth2 오버라이드 :  OAuth2 공급자에서 제공된 사용자 정보를 가져올 때 사용됩니다. 
    // 이 메서드는 사용자 정보의 키-값 쌍을 담은 맵을 반환해야 합니다. 
    // 이 맵은 사용자의 이름, 이메일, 권한 등 다양한 정보를 포함할 수 있습니다.
	@Override
	public Map<String, Object> getAttributes() {
		return this.getProps();
	}
	
	// OAuth2 오버라이드 : 사용자의 이름을 반환해야 합니다. 이 이름은 일반적으로 사용자를 식별하는 고유한 값일 수 있습니다.
	@Override
	public String getName() {
		return this.getMemberId();
	}
}
