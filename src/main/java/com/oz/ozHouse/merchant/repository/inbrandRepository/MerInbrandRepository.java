package com.oz.ozHouse.merchant.repository.inbrandRepository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.oz.ozHouse.domain.Inbrand;

import jakarta.transaction.Transactional;


public interface MerInbrandRepository 
	extends JpaRepository<Inbrand, Integer>, MerInbrandRepositoryCustum{

	@Transactional
	@Modifying
	@Query("update Inbrand i set i.inCancelDate = :inCancelDate where inNum = :inNum")
	int updateCancelDate(@Param("inCancelDate") String inCancelDate, 
			@Param("inNum") int inNum);
}
