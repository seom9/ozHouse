package com.oz.ozHouse.client.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oz.ozHouse.domain.MerCoupon;

public interface ClientMerCouponRepository extends JpaRepository<MerCoupon, Integer>{
	
	List<MerCoupon> findAll();
	
	MerCoupon findByMerCouponnum(int merCouponnum);
}
