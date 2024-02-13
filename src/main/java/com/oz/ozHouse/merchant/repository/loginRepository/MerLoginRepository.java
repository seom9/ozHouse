package com.oz.ozHouse.merchant.repository.loginRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.oz.ozHouse.domain.Merchant;

import jakarta.transaction.Transactional;

public interface MerLoginRepository 
	extends MerLoginRepositoryCustom, JpaRepository<Merchant, Integer>{

	@Transactional
	@Modifying
	@Query("update Merchant m set m.merPw = :merPw where merId = :merId")
	int updateMerchantPw(@Param("merPw") String merPw, @Param("merId") String merId);
}
