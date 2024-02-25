package com.oz.ozHouse.merchant.repository.merCouponRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oz.ozHouse.domain.MerCoupon;
import com.oz.ozHouse.domain.Merchant;

public interface MerCouponRepository extends JpaRepository<MerCoupon, Integer>, MerCouponCustomRepository {

	public List<MerCoupon> findAllByMerNum(Merchant merNum);
}
