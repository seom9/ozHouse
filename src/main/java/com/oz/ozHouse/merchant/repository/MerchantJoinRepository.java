package com.oz.ozHouse.merchant.repository;

import java.util.Map;

import org.springframework.data.repository.Repository;

import com.oz.ozHouse.domain.Merchant;
import com.oz.ozHouse.dto.MerchantDTO;

public interface MerchantJoinRepository extends Repository<Merchant, Integer>{  //Repository<Entity 클래스, PK 타입>

	//사업자등록번호로 판매자 조회
	MerchantDTO findMerchantComnum(Map<String, String> comNum); 
	//Email로 판매자 조회
	public MerchantDTO findMerchantEmail(String email);
	//ID로 판매자 조회
	public MerchantDTO findMerchantId(String id);
}
