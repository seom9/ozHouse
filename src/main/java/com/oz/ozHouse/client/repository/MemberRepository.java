package com.oz.ozHouse.client.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.oz.ozHouse.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {
	
	int countByMemberId(String memberId);		// 멤버 찾기
	
	int countByMemberEmail(String memberEmail);	// email 찾기
	
	Member findByMemberId(String memberId);
	
	boolean existsByMemberId(String memberId);
	
	// member 로그인 시 memberRole 같이 로딩
	@EntityGraph(attributePaths = "roleSet")
	@Query("select m from Member m where m.memberId = :memberId and m.social = false")
	Optional<Member> getWithRole(@Param("memberId") String memberId);
	

}