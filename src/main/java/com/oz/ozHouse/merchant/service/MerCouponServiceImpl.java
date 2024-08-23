package com.oz.ozHouse.merchant.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import com.oz.ozHouse.domain.MerCoupon;
import com.oz.ozHouse.domain.Merchant;
import com.oz.ozHouse.dto.MerCouponDTO;
import com.oz.ozHouse.dto.merchant.CouponSearchDTO;
import com.oz.ozHouse.dto.merchant.InsertMerCouponDTO;
import com.oz.ozHouse.merchant.repository.merCouponRepository.MerCouponRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MerCouponServiceImpl implements MerCouponService {
	private final MerCouponRepository couponRepository;
	
	public static MerCoupon setEntity(InsertMerCouponDTO dto) {
		System.out.println("coupon DTO -> entity 변환");
		Merchant m = Merchant.builder()
				.merNum(dto.getMerNum()).build();
		return MerCoupon.builder()
				.merCouponname(dto.getMerCouponname())
				.merIsok("f")
				.merCoupondiscount(dto.getMerCoupondiscount())
				.merNum(m)
				.merCouponusedate(dto.getMerCouponusedate())
				.merCouponenddate(dto.getMerCouponenddate())
				.build();
	}
	
	@Override
	public int merCouponInsert(InsertMerCouponDTO dto) {
		MerCoupon mc = setEntity(dto);
		try {
			couponRepository.save(mc);
			System.out.println("coupon 저장 완료,mc : " + mc.getMerCouponname());
		}catch(IllegalArgumentException e) {
			return -1;
		}catch(OptimisticLockingFailureException e) {
			return -1;
		}
		return 1;
	}
	
	public static List<MerCouponDTO> setCouponList(List<MerCoupon> list){
		List<MerCouponDTO> listDto = new ArrayList<>();
		for(MerCoupon c : list) {
			MerCouponDTO dto = MerCouponDTO.builder()
					.merCouponnum(c.getMerCouponnum())
					.merNum(c.getMerNum().getMerNum())
					.merCouponname(c.getMerCouponname())
					.merIsok(c.getMerIsok())
					.merCoupondiscount(c.getMerCoupondiscount())
					.merCouponusedate(c.getMerCouponusedate())
					.merCouponenddate(c.getMerCouponenddate())
					.build();
			listDto.add(dto);
		}
		return listDto;
	}

	@Override
	public List<MerCouponDTO> couponList(int merNum) {
		Merchant m = Merchant.builder().merNum(merNum).build();
		System.out.println("쿠폰 조회(coupon)");
		List<MerCoupon> list = couponRepository.findAllByMerNum(m);
		List<MerCouponDTO> listDto = setCouponList(list);
		return listDto;
	}

	@Override
	public int merCouponDelete(int merCouponnum) {
		System.out.println("쿠폰 삭제(coupon)");
		return couponRepository.merCouponDelete(merCouponnum);
	}

	@Override
	public List<MerCouponDTO> searchCouponList(Map<String, String> map) {
		System.out.println("쿠폰 검색(coupon)");
		List<MerCoupon> list = couponRepository.searchCouponList(map);
		List<MerCouponDTO> listDto = setCouponList(list);
		return listDto;
	}

}
