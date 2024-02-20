package com.oz.ozHouse.client.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oz.ozHouse.domain.UserCoupon;

public interface UserCouponRepository extends JpaRepository<UserCoupon, Integer>{
	
	 List<UserCoupon> findByMember_MemberId(String memberId);
	
}
