package com.oz.ozHouse.client.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.oz.ozHouse.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {
	
	int countByMemberId(String memberId);		// 멤버 찾기
	
	int countByMemberEmail(String memberEmail);	// email 찾기
	
	Member findByMemberId(String memberId);
	
	@EntityGraph(attributePaths = "roleSet")
	@Query("select m from member m where m.memberNum = :memberNum and m.social = false")
	Optional<Member> getWithRole(String mid);
	
}