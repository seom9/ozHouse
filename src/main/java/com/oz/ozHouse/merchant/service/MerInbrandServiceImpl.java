package com.oz.ozHouse.merchant.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.oz.ozHouse.domain.Inbrand;
import com.oz.ozHouse.domain.Merchant;
import com.oz.ozHouse.domain.common.CompanyNumber;
import com.oz.ozHouse.domain.common.InbrandInfo;
import com.oz.ozHouse.domain.common.PhoneNumber;
import com.oz.ozHouse.dto.ApplicationDTO;
import com.oz.ozHouse.dto.InbrandDTO;
import com.oz.ozHouse.merchant.exception.NotFoundMerNumException;
import com.oz.ozHouse.merchant.repository.inbrandRepository.MerInbrandRepository;
import com.oz.ozHouse.merchant.repository.merchantRepository.MerchantRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MerInbrandServiceImpl implements MerInbrandService {
	private final MerInbrandRepository inbrandRepository;
	private final MerchantRepository merRepository;

	@Override
	public InbrandDTO selectMer(int merNum) {
		System.out.println("이전 입점신청 내역 조회(Inbrand)");
		Inbrand inbrand = inbrandRepository.selectMerNum(merNum);
	    InbrandDTO dto = new InbrandDTO();
	    if (inbrand!=null) {
	        dto = dto.toDto(inbrand);
	    } else {
	        dto = null;
	    }
	    return dto;
	}

	@Override
	public boolean searchComNum(int merNum, Map<String, String> map) throws NotFoundMerNumException {
		System.out.println("가입한 사업자등록번호 조회(Inbrand)");
		Optional<Merchant> optionalMerchant = merRepository.findById(merNum);
		if(optionalMerchant.isPresent()) {
			Merchant merchant = optionalMerchant.get();
			String num1 = merchant.getMerComnum().merComnum1;
			String num2 = merchant.getMerComnum().merComnum2;
			String num3 = merchant.getMerComnum().merComnum3;
			if(num1.equals(map.get("inComnum1"))&&num2.equals(map.get("inComnum2"))
					&&num3.equals(map.get("inComnum3"))) {
				return true;
			}else {
				return false;
			}
		}else {
			throw new NotFoundMerNumException("등록된 판매자 번호가 존재하지 않습니다.");
		}
	}

	@Override
	public void deleteInbrand(int inNum) {
		System.out.println("이전 입점신청 내역 삭제(Inbrand)");
		inbrandRepository.deleteById(inNum);
	}
	
	private Inbrand setInbrandEntity(InbrandDTO dto) {
		PhoneNumber phone = PhoneNumber.builder()
				.phoneNumber1(dto.getInManhp1())
				.phoneNumber2(dto.getInManhp2())
				.phoneNumber3(dto.getInManhp3())
				.build();
		InbrandInfo i = InbrandInfo.builder()
				.homepage(dto.getInHomepage())
				.ManagerName(dto.getInManname())
				.phoneNum(phone)
				.ManagerEmail(dto.getInManemail())
				.category(dto.getInCategory())
				.otherShop(dto.getInOthershop())
				.brandFile(dto.getInSaleFile())
				.build();
				
		Merchant m = Merchant.builder()
				.merNum(dto.getMerNum()).build();
		CompanyNumber comNum = CompanyNumber.builder()
				.merComnum1(dto.getInComnum1())
				.merComnum2(dto.getInComnum2())
				.merComnum3(dto.getInComnum3())
				.build();
		
		SimpleDateFormat df = new SimpleDateFormat("yy/MM/dd");
		Date date = new Date();
		Inbrand inbrand = Inbrand.builder()
				.merchant(m)
				.inCompany(dto.getInCompany())
				.inComnum(comNum)
				.inbrandInfo(i)
				.inAppliDate(df.format(date))
				.build();
		return inbrand;
	}

	@Override
	public int application(InbrandDTO dto) {
		Inbrand inbrand = setInbrandEntity(dto);
		try {
			System.out.println("입점신청 내용 저장(Inbrand)");
			inbrandRepository.save(inbrand);
		}catch(IllegalArgumentException e) {
			return -1;
		}
		return 1;
	}

	@Override
	public ApplicationDTO applicationList(int merNum) {
		System.out.println("이전 입점신청 상세내역 조회(Inbrand)");
		Inbrand inbrand = inbrandRepository.selectMerNum(merNum);
		ApplicationDTO dto = ApplicationDTO.builder()
				.inNum(inbrand.getInNum())
				.merNum(inbrand.getMerchant().getMerNum())
				.merIsbrand(inbrand.getMerchant().getMerIsbrand())
				.inCompany(inbrand.getInCompany())
				.inComnum1(inbrand.getInComnum().getMerComnum1())
				.inComnum2(inbrand.getInComnum().getMerComnum2())
				.inComnum3(inbrand.getInComnum().getMerComnum3())
				.inHomepage(inbrand.getInbrandInfo().getHomepage())
				.inManname(inbrand.getInbrandInfo().getManagerName())
				.inManhp1(inbrand.getInbrandInfo().getPhoneNum().getPhoneNumber1())
				.inManhp2(inbrand.getInbrandInfo().getPhoneNum().getPhoneNumber2())
				.inManhp3(inbrand.getInbrandInfo().getPhoneNum().getPhoneNumber3())
				.inManemail(inbrand.getInbrandInfo().getManagerEmail())
				.inCategory(inbrand.getInbrandInfo().getCategory())
				.inOthershop(inbrand.getInbrandInfo().getOtherShop())
				.inSaleFile(inbrand.getInbrandInfo().getBrandFile())
				.inAppliDate(inbrand.getInAppliDate())
				.inCancelDate(inbrand.getInCancelDate())
				.build();
		return dto;
	}

	@Override
	public int brandCancel(int inNum) {
		SimpleDateFormat df = new SimpleDateFormat("yy/MM/dd");
		Date date = new Date();
		System.out.println("입점신청 취소일 업데이트(Inbrand)");
		int result = inbrandRepository.updateCancelDate(df.format(date), inNum);
		return result;
	}
	
}
