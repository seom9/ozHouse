package com.oz.ozHouse.merchant.repository.merchantRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.oz.ozHouse.domain.Merchant;

import jakarta.transaction.Transactional;

public interface MerchantRepository 
extends JpaRepository<Merchant, Integer>, MerchantRepositoryCustom{

	//판매자의 사업자등록번호 조회
	@Transactional
	@Modifying
	@Query("SELECT m FROM Merchant m where m.merComnum.merComnum1 = :value1 AND m.merComnum.merComnum2 = :value2 AND m.merComnum.merComnum3 = :value3")
	Merchant searchMerComnum(@Param("value1") String merComnum1, @Param("value2") String merComnum2, @Param("value3") String merComnum3);

	//판매자의 email조회
	public Merchant findMerchantByMerEmail(String email);
	
	@Transactional
	@Modifying
	@Query("update Merchant m set m.merPw = :merPw where merId = :merId")
	int updateMerchantPw(@Param("merPw") String merPw, @Param("merId") String merId);
	
}
