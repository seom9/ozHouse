package com.oz.ozHouse.client.service;

import com.oz.ozHouse.dto.MemberDTO;

public interface MemberService {
	int insertMember(MemberDTO member);
	int checkId(String memberId);
	int checkEmail(String memberEmail);
}