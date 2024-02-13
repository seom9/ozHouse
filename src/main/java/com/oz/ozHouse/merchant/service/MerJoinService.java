package com.oz.ozHouse.merchant.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.oz.ozHouse.dto.MerchantDTO;

@Service
public interface MerJoinService {
	//사업자등록번호 조회
	public boolean merchant_checkBsNum(String comnum1, String comnum2, String comnum3);
	//Email 조회
	public boolean merchant_checkEmail(String email);
	//ID 중복 조회
	public MerchantDTO merchant_checkMerId(String id);
	//판매자 추가
	public String insertMerchant(MerchantDTO dto);
}
