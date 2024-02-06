package com.oz.ozHouse.client.config;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.oz.ozHouse.client.service.MemberService;
import com.oz.ozHouse.dto.MemberDTO;


public class LoginOkBean {
	private String member_id;
	private String member_passwd;
	
	public static final int OK = 0;
	public static final int NOT_ID = 1;
	public static final int NOT_PW = 2;
	public static final int WITH_DRAW = 3;
	public static final int ERROR = -1;
	
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public void setMember_passwd(String member_passwd) {
		this.member_passwd = member_passwd;
	}
	public String getMember_id() {
		return member_id;
	}
	public int loginOk(MemberService memberService, PasswordEncoder passwordEncoder) {
		try {  
			MemberDTO dto = memberService.getMember(member_id);

			if (dto != null) {
				if (passwordEncoder.matches(member_passwd, dto.getMemberPasswd())) {
					if (dto.getMemberDeletedate() != null) return WITH_DRAW;
					return OK;
				}else {
					return NOT_PW;
				}
			}else {
				return NOT_ID;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
}
