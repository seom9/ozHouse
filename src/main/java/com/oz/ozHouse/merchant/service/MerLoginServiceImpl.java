package com.oz.ozHouse.merchant.service;

import org.springframework.stereotype.Service;

import com.oz.ozHouse.domain.Merchant;
import com.oz.ozHouse.dto.MerchantDTO;
import com.oz.ozHouse.merchant.repository.merchantRepository.MerchantRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MerLoginServiceImpl implements MerLoginService {
	private final MerchantRepository merRepository;
	
	@Override
	public MerchantDTO merchant_getMember(String mer_id) {
		MerchantDTO dto = merRepository.findMerchantId(mer_id);
		return dto;
	}

	@Override
	public String checkMerchantIdEmail(String mer_email) {
		Merchant m = merRepository.findMerchantEmail(mer_email);
		String merId = m.getMerId();
		return merId;
	}

	@Override
	public int updatePass(String merPw, String merId) {
		int result = merRepository.updateMerchantPw(merPw, merId);
		return result;
	}

}
