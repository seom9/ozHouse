package com.oz.ozHouse.merchant.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.oz.ozHouse.domain.Merchant;
import com.oz.ozHouse.dto.MerchantDTO;
import com.oz.ozHouse.merchant.repository.merchantRepository.MerchantRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MerLoginServiceImpl implements MerLoginService {
	private final MerchantRepository joinRepository;
	
	@Override
	public MerchantDTO merchant_getMember(String mer_id) {
		MerchantDTO dto = joinRepository.findMerchantId(mer_id);
		return dto;
	}

	@Override
	public String checkMerchantIdEmail(String mer_email) {
		Merchant m = joinRepository.findMerchantEmail(mer_email);
		String merId = m.getMerId();
		return merId;
	}

	@Override
	public int updatePass(String merPw, String merId) {
		int result = joinRepository.updateMerchantPw(merPw, merId);
		return result;
	}

}
