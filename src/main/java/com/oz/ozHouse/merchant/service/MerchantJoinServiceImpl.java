package com.oz.ozHouse.merchant.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.oz.ozHouse.domain.Merchant;
import com.oz.ozHouse.dto.MerchantDTO;
import com.oz.ozHouse.repository.MerchantJoinRepositoryImpl;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MerchantJoinServiceImpl implements MerchantJoinService{
	private final MerchantJoinRepositoryImpl repository;
	
	public boolean merchant_checkBsNum(Map<String, String> comNum) {
		MerchantDTO mer = repository.findMerchantComnum(comNum);
		if(mer == null) {
			return false; 
    	}else return true;
    }
	
	public boolean merchant_checkEmail(String email) {
		MerchantDTO mer = repository.findMerchantEmail(email);
		if(mer == null) {
			return false; 
    	}else return true;
    }
}
