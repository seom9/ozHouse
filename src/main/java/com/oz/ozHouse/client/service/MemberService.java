package com.oz.ozHouse.client.service;

import com.oz.ozHouse.domain.Member;

public interface MemberService {
	int insertMember(Member member);
	int checkId(String memberId);
	int checkEmail(String memberEmail);
}