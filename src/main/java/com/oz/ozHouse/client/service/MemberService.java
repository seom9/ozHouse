package com.oz.ozHouse.client.service;

import com.oz.ozHouse.dto.MemberDTO;

public interface MemberService {
	String insertMember(MemberDTO member);
	int checkId(String memberId);
	int checkEmail(String memberEmail);
	MemberDTO getMember(String memberId);
}