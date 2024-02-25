package com.oz.ozHouse.client.service;

import com.oz.ozHouse.domain.Member;
import com.oz.ozHouse.dto.MemberDTO;
import com.oz.ozHouse.dto.client.member.MemberJoinDTO;

public interface MemberService {

	// 회원 가입
	String join(MemberJoinDTO memberJoinDTO) throws IdExistException;
	
	// 회원 가입 (regacy)
	String insertMember(MemberDTO member);
	
	// 아이디 중복 확인
	int checkId(String memberId);
	
	// 이메일 중복 확인
	int checkEmail(String memberEmail);
	
	// 멤버 entity 불러오기
	Member getMemberEntity(String memberId);
	
	// 멤버 entity DTO 로 불러오기
	MemberDTO getMember(String memberId);
	
	// 멤버 정보
	int updateMember(Member member);

	// exception 설정
	static class IdExistException extends Exception {
		// 만약 id 가 없다면 exception 발생
	}
	
	// 멤버 탈퇴
	int deleteMember(String memberId);
	
	// 멤버 포인트 업데이트
	void updatePoint(String memberId, int point);
}