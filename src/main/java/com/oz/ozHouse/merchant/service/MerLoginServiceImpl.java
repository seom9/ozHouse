package com.oz.ozHouse.merchant.service;

import org.springframework.stereotype.Service;

import com.oz.ozHouse.dto.MerchantDTO;
import com.oz.ozHouse.merchant.repository.MerJoinRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MerLoginServiceImpl implements MerLoginService {

	private final MerJoinRepository joinRepository;
	
	@Override
	public MerchantDTO merchant_getMember(String mer_id) {
		return joinRepository.findMerchantId(mer_id);
	}

}
