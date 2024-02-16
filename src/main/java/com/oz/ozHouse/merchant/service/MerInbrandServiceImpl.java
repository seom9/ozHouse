package com.oz.ozHouse.merchant.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.oz.ozHouse.domain.Inbrand;
import com.oz.ozHouse.domain.Merchant;
import com.oz.ozHouse.dto.InbrandDTO;
import com.oz.ozHouse.dto.MerchantDTO;
import com.oz.ozHouse.merchant.Exception.NotFoundMerNumException;
import com.oz.ozHouse.merchant.repository.MerInbrandRepository;
import com.oz.ozHouse.merchant.repository.joinRepository.MerJoinRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MerInbrandServiceImpl implements MerInbrandService {
	private final MerInbrandRepository inbrandRepository;
	private final MerJoinRepository joinRepository;

	@Override
	public InbrandDTO selectMer(int merNum) {

		Optional<Inbrand> optionalInbrand = inbrandRepository.findById(merNum);
	    InbrandDTO dto = new InbrandDTO();
	    
	    if (optionalInbrand.isPresent()) {
	        Inbrand inbrand = optionalInbrand.get();
	    } else {
	        dto = null;
	    }
	    
	    return dto;
	}

	@Override
	public boolean searchComNum(int merNum, Map<String, String> map) throws NotFoundMerNumException {
		Optional<Merchant> optionalMerchant = joinRepository.findById(merNum);
		if(optionalMerchant.isPresent()) {
			Merchant merchant = optionalMerchant.get();
			String num1 = merchant.getMerComnum().merComnum1;
			String num2 = merchant.getMerComnum().merComnum2;
			String num3 = merchant.getMerComnum().merComnum3;
			if(num1.equals(map.get("inComNum1"))&&num2.equals(map.get("inComNum2"))
					&&num3.equals(map.get("inComNum3"))) {
				return true;
			}else {
				return false;
			}
		}else {
			throw new NotFoundMerNumException("등록된 판매자 번호가 존재하지 않습니다.");
		}
	}
	
}
