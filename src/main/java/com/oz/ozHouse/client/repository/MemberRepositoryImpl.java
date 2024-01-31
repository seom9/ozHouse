package com.oz.ozHouse.client.repository;

import org.springframework.stereotype.Repository;

import com.oz.ozHouse.domain.Member;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl {
    private final EntityManager em;
    
    public Member save(Member member) {
        em.persist(member);
        return member;
    }
}
