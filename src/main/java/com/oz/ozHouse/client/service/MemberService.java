package com.oz.ozHouse.client.service;

import com.oz.ozHouse.domain.Member;
import com.oz.ozHouse.dto.MemberDTO;
import com.oz.ozHouse.dto.client.member.MemberJoinDTO;

public interface MemberService {
	String insertMember(MemberDTO member);
	int checkId(String memberId);
	int checkEmail(String memberEmail);
	MemberDTO getMember(String memberId);
	int updateMember(Member member);
	Member getMemberEntity(String memberId);
	
	String join(MemberJoinDTO memberJoinDTO) throws IdExistException;
	
	static class IdExistException extends Exception {
		// 멤버 아이디가 이미 존재하면 exception 발생
	}
}