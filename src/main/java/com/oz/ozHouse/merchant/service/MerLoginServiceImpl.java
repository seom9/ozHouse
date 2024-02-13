package com.oz.ozHouse.merchant.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.oz.ozHouse.domain.Merchant;
import com.oz.ozHouse.dto.MerchantDTO;
import com.oz.ozHouse.merchant.repository.joinRepository.MerJoinRepositoy;
import com.oz.ozHouse.merchant.repository.loginRepository.MerLoginRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MerLoginServiceImpl implements MerLoginService {
	private final MerLoginRepository loginRepository;
	private final MerJoinRepositoy joinRepository;
	
	@Override
	public MerchantDTO merchant_getMember(String mer_id) {
		MerchantDTO dto = joinRepository.findMerchantId(mer_id);
		return dto;
	}

	@Override
	public String checkMerchantIdEmail(String mer_email) {
		Merchant m = loginRepository.findMerchantEmail(mer_email);
		String merId = m.getMerId();
		return merId;
	}

	@Override
	public boolean updatePass(String merPw, String merId) {
		boolean result = loginRepository.updateMerchantPw(merPw, merId);
		
		return result;
	}

}
