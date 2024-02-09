package com.oz.ozHouse.merchant.service;

import org.springframework.stereotype.Service;

import com.oz.ozHouse.domain.Merchant;
import com.oz.ozHouse.dto.MerchantDTO;
import com.oz.ozHouse.merchant.repository.joinRepository.MerJoinRepositoy;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MerLoginServiceImpl implements MerLoginService {

	private final MerJoinRepositoy joinRepository;
	
	@Override
	public MerchantDTO merchant_getMember(String mer_id) {
		
		MerchantDTO dto = joinRepository.findMerchantId(mer_id);
//		Merchant mer = joinRepository.findMerchantId(mer_id);
//		MerchantDTO dto= new MerchantDTO();
//		if(mer == null) {
//			dto = null;
//		}else{
//			dto.toDto(mer);
//		}
		return dto;
	}

}
