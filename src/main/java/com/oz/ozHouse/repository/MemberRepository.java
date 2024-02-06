package com.oz.ozHouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oz.ozHouse.domain.Member;
import com.oz.ozHouse.dto.MemberDTO;

public interface MemberRepository extends JpaRepository<Member, Integer> {
	int countByMemberId(String memberId);		// 멤버 찾기
	int countByMemberEmail(String memberEmail);	// email 찾기
	MemberDTO findByMemberId(String memberId);
}