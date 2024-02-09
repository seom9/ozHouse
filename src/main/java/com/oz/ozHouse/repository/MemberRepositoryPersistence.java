package com.oz.ozHouse.repository;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryPersistence {
    private final EntityManager em;
    // 혹시 몰라서 생성 
}
