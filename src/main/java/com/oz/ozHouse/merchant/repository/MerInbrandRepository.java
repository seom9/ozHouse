package com.oz.ozHouse.merchant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oz.ozHouse.domain.Inbrand;

@Repository
public interface MerInbrandRepository extends JpaRepository<Inbrand, Integer>{

	//판매자 번호로 입점내역 조회
	public Inbrand findInbrandByMerchant_MerNum(int merNum);
}
