package com.oz.ozHouse.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oz.ozHouse.domain.Member;
import com.oz.ozHouse.domain.Product;
import com.oz.ozHouse.domain.Scrap;

public interface ScrapRepository extends JpaRepository<Scrap, Integer> {
	
	boolean existsByMemberAndProduct(Member member, Product product);
	
}
