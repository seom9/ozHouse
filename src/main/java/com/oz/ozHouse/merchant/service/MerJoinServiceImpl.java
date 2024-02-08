package com.oz.ozHouse.merchant.service;

import org.springframework.stereotype.Service;

import com.oz.ozHouse.domain.Merchant;
import com.oz.ozHouse.dto.MerchantDTO;
import com.oz.ozHouse.merchant.repository.joinRepository.MerJoinRepositoy;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MerJoinServiceImpl implements MerJoinService{
	private final MerJoinRepositoy repository;
	
	@Override
	public boolean merchant_checkBsNum(String comnum1, String comnum2, String comnum3) {
		Merchant mer = repository.searchMerComnum(comnum1, comnum2, comnum3);
		if(mer == null) {
			return false; 
    	}else return true;
    }

	@Override
	public boolean merchant_checkEmail(String email) {
		Merchant mer = repository.findMerchantByMerEmail(email);
		if(mer == null) {
			return false; 
    	}else return true;
    }
	
	@Override
	public MerchantDTO merchant_checkMerId(String id) {
		Merchant mer = repository.findMerchantByMerId(id);
		MerchantDTO dto= new MerchantDTO();
		if(mer == null) {
			dto = null;
		}else{
			dto.toDto(mer);
		}
		return dto;
    }

	@Override
	public String insertMerchant(MerchantDTO dto) {
		Merchant mer = new Merchant(dto);
		repository.save(mer);
		return dto.getMerId();
	}
}
