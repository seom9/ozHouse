package com.oz.ozHouse.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oz.ozHouse.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {
	int countByMemberId(String member_id);
}
