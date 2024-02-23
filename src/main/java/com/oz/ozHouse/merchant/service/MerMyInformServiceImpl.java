package com.oz.ozHouse.merchant.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.oz.ozHouse.domain.Inbrand;
import com.oz.ozHouse.domain.Merchant;
import com.oz.ozHouse.domain.common.InbrandInfo;
import com.oz.ozHouse.domain.common.PhoneNumber;
import com.oz.ozHouse.dto.MerchantDTO;
import com.oz.ozHouse.dto.MerchantUpdateDTO;
import com.oz.ozHouse.merchant.exception.NotFoundMerNumException;
import com.oz.ozHouse.merchant.repository.merchantRepository.MerchantRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MerMyInformServiceImpl implements MerMyInformService {
	private final MerchantRepository merRepository;
	
	@Override
	public MerchantDTO myInformView(int merNum) throws NotFoundMerNumException {
		System.out.println("판매자 정보 조회");
		Optional<Merchant> merchant = merRepository.findById(merNum);
		MerchantDTO dto = null;
		if(merchant.isPresent()) {
			dto = setMerchantEntity(merchant.get());
		}else {
			throw new NotFoundMerNumException("등록된 판매자 번호가 존재하지 않습니다.");
		}
		return dto;
	}
	
	private Merchant setUpdateMerchant(MerchantUpdateDTO dto, Merchant merchant) {
		PhoneNumber merHp = PhoneNumber.builder()
				.phoneNumber1(dto.getMerHp1())
				.phoneNumber2(dto.getMerHp2())
				.phoneNumber3(dto.getMerHp3())
				.build();
		
		InbrandInfo info = merchant.getInbrand().getInbrandInfo().toBuilder()
				.brandFile(dto.getInSaleFile())
				.homepage(dto.getInHomepage())
				.otherShop(dto.getInOthershop())
				.build();
		
		Inbrand inbrand = merchant.getInbrand().toBuilder()
				.inbrandInfo(info).build();
		
		return merchant.toBuilder()
				.merBusinessPost(dto.getMerBusinessPost())
				.merAdress(dto.getMerAdress())
				.merRegistration(dto.getMerRegistration())
				.merName(dto.getMerName())
				.merHp(merHp)
				.merEmail(dto.getMerEmail())
				.inbrand(inbrand)
				.build();
	}

	@Override
	public String updateMerchant(MerchantUpdateDTO dto, Merchant merchant) {
		Merchant m = setUpdateMerchant(dto, merchant);
		System.out.println("판매자 정보 업데이트");
		merRepository.save(m);
		return m.getMerId();
	}
	
	private MerchantDTO setMerchantEntity(Merchant m) {
		if(m.getInbrand() == null || m.getInbrand().getInCancelDate()!=null) {
			return MerchantDTO.builder()
					.merNum(m.getMerNum())
					.merId(m.getMerId())
					.merPw(m.getMerPw())
					.merCompany(m.getMerCompany())
					.merIsbrand(m.getMerIsbrand())
					.merComnum1(m.getMerComnum().getMerComnum1())
					.merComnum2(m.getMerComnum().getMerComnum2())
					.merComnum3(m.getMerComnum().getMerComnum3())
					.merHp1(m.getMerHp().getPhoneNumber1())
					.merHp2(m.getMerHp().getPhoneNumber2())
					.merHp3(m.getMerHp().getPhoneNumber3())
					.merHomepage("미등록")
					.merManname("담당자 지정 전")
					.merManhp1("담당자 지정 전")
					.merManemail("담당자 지정 전")
					.merOthershop("미등록")
					.merFile("미등록")
					.merJoindate(m.getMerJoindate())
					.merInbranddate(m.getMerInbranddate())
					.merDeletedate(m.getMerDeletedate())
					.merAdress(m.getMerAdress())
					.merRegistration(m.getMerRegistration())
					.merName(m.getMerName())
					.merEmail(m.getMerEmail())
					.merBusinessPost(m.getMerBusinessPost())
					.build();
		}else {
			return MerchantDTO.builder()
					.merNum(m.getMerNum())
					.merId(m.getMerId())
					.merPw(m.getMerPw())
					.merCompany(m.getMerCompany())
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

	@Override
	public Merchant getMerchant(int merNum) {
		Optional<Merchant> m = merRepository.findById(merNum);
		return m.get();
	}

	@Override
	public int updatePass(String merPw, int merNum) {
		System.out.println("비밀번호 재설정(MyInform)");
		int result = merRepository.updateMerchantPw(merPw, merNum);
		return result;
	}
}
