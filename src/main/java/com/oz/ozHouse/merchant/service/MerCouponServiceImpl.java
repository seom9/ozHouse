package com.oz.ozHouse.merchant.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import com.oz.ozHouse.domain.MerCoupon;
import com.oz.ozHouse.domain.Merchant;
import com.oz.ozHouse.dto.InsertMerCouponDTO;
import com.oz.ozHouse.dto.MerCouponDTO;
import com.oz.ozHouse.merchant.repository.merCouponRepository.MerCouponRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MerCouponServiceImpl implements MerCouponService {
	private final MerCouponRepository couponRepository;
	
	public static MerCoupon setEntity(InsertMerCouponDTO dto) {
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
		}catch(IllegalArgumentException e) {
			return -1;
		}catch(OptimisticLockingFailureException e) {
			return -1;
		}
		return 1;
	}

	@Override
	public List<MerCouponDTO> searchCouponList(int merNum) {
		Merchant m = Merchant.builder().merNum(merNum).build();
		List<MerCoupon> list = couponRepository.findAllByMerNum(m);
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
	public int merCouponDelete(int merCouponnum) {
		System.out.println("쿠폰 삭제(coupon)");
		return couponRepository.merCouponDelete(merCouponnum);
	}

}
