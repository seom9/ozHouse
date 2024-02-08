package com.oz.ozHouse.merchant.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.oz.ozHouse.domain.Merchant;
import com.oz.ozHouse.dto.MerchantDTO;
import com.oz.ozHouse.merchant.repository.MerJoinRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MerJoinServiceImpl implements MerJoinService{
	private final MerJoinRepository repository;
	
	@Override
	public boolean merchant_checkBsNum(Map<String, String> comNum) {
		MerchantDTO mer = repository.findMerchantComnum(comNum);
		//System.out.println("dto -> merComnum1 : " + mer.getMerComnum1());
		if(mer == null) {
			return false; 
    	}else return true;
    }

	@Override
	public boolean merchant_checkEmail(String email) {
		MerchantDTO mer = repository.findMerchantEmail(email);
		if(mer == null) {
			return false; 
    	}else return true;
    }
	
	@Override
	public MerchantDTO merchant_checkMerId(String id) {
		return repository.findMerchantId(id);
    }

	@Override
	public String insertMerchant(MerchantDTO dto) {
		Merchant mer = new Merchant(dto);
		repository.save(mer);
		return dto.getMerId();
	}
}
