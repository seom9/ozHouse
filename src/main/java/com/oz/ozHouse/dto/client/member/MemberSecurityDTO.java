package com.oz.ozHouse.dto.client.member;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;

@Getter
public class MemberSecurityDTO extends User {
	private int memberNum;
	private String memberId;
	private String memberPasswd;
    private String memberNickname;
    private String memberEmail;
    private LocalDate memberDeleteDate;
    private boolean social;
    
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
}
