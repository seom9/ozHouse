package com.oz.ozHouse.client.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.oz.ozHouse.domain.Member;

import jakarta.transaction.Transactional;

public interface MemberRepository extends JpaRepository<Member, Integer> {
	
	int countByMemberId(String memberId);		// 멤버 찾기
	
	int countByMemberEmail(String memberEmail);	// email 찾기
	
	Member findByMemberId(String memberId);
	
	boolean existsByMemberId(String memberId);
	
	// Security : member 로그인 시 memberRole 같이 로딩
	@EntityGraph(attributePaths = "roleSet")
	@Query("select m from Member m where m.memberId = :memberId and m.social = false")
	Optional<Member> getWithRole(@Param("memberId") String memberId);
	
	// Security(OAuth2) : email 로 회원 정보 찾기
	@EntityGraph(attributePaths = "roleSet")
	Optional<Member> findByMemberEmail(String memberEmail);
	
    @Transactional
    @Modifying
    @Query("UPDATE Member m SET m.social = true WHERE m.memberId = :memberId")
    void updateSocialStatusByMemberId(@Param("memberId") String memberId);
    
    // passwd 수정
    @Transactional
    @Modifying
    @Query("UPDATE Member m SET m.memberPasswd = :encodePass WHERE m.memberId = :memberId")
    void updateMemberPasswdByMemberId(@Param("encodePass") String encodePass, @Param("memberId") String memberId);

    
    @Transactional
    @Modifying
    @Query("UPDATE Member m SET m.memberPasswd = :encodePass WHERE m.memberEmail = :memberEmail")
    void updateMemberPasswdByMemberEmail(@Param("encodePass") String encodePass, @Param("memberEmail") String memberEmail);

}