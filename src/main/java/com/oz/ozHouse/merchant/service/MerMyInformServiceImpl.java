package com.oz.ozHouse.merchant.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.oz.ozHouse.domain.Merchant;
import com.oz.ozHouse.dto.MerchantDTO;
import com.oz.ozHouse.merchant.exception.NotFoundMerNumException;
import com.oz.ozHouse.merchant.repository.merchantRepository.MerchantRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MerMyInformServiceImpl implements MerMyInformService {
	private final MerchantRepository merRepository;
	
	@Override
	public MerchantDTO myInformView(int merNum) throws NotFoundMerNumException {
		Optional<Merchant> merchant = merRepository.findById(merNum);
		MerchantDTO dto = null;
		if(merchant.isPresent()) {
			dto = setMerchantEntity(merchant.get());
		}else {
			throw new NotFoundMerNumException("등록된 판매자 번호가 존재하지 않습니다.");
		}
		return dto;
	}
	
	private MerchantDTO setMerchantEntity(Merchant m) {
		return MerchantDTO.builder()
				.merNum(m.getMerNum())
				.merId(m.getMerId())
				.merPw(m.getMerPw())
				.merIsbrand(m.getMerIsbrand())
				.merComnum1(m.getMerComnum().getMerComnum1())
				.merComnum2(m.getMerComnum().getMerComnum2())
				.merComnum3(m.getMerComnum().getMerComnum3())
				.merHp1(m.getMerHp().getPhoneNumber1())
				.merHp2(m.getMerHp().getPhoneNumber2())
				.merHp3(m.getMerHp().getPhoneNumber3())
				.merHomepage(m.getInbrand().getInbrandInfo().getHomepage())
				.merManname(m.getInbrand().getInbrandInfo().getManagerName())
				.merManhp1(m.getInbrand().getInbrandInfo().getPhoneNum().phoneNumber1)
				.merManhp2(m.getInbrand().getInbrandInfo().getPhoneNum().phoneNumber2)
				.merManhp3(m.getInbrand().getInbrandInfo().getPhoneNum().phoneNumber3)
				.merManemail(m.getInbrand().getInbrandInfo().getManagerEmail())
				.merCategory(m.getInbrand().getInbrandInfo().getCategory())
				.merOthershop(m.getInbrand().getInbrandInfo().getOtherShop())
				.merFile(m.getInbrand().getInbrandInfo().getBrandFile())
				.merJoindate(m.getMerJoindate())
				.merInbranddate(m.getMerInbranddate())
				.merDeletedate(m.getMerDeletedate())
				.merAdress(m.getMerAdress())
				.merRegistration(m.getMerRegistration())
				.merName(m.getMerName())
				.merEmail(m.getMerEmail())
				.merBusinessPost(m.getMerBusinessPost())
				.build();
	}
}
