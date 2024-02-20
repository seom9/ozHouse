package com.oz.ozHouse.domain;

import com.oz.ozHouse.domain.common.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder(toBuilder = true)
@Getter 
@AllArgsConstructor
@NoArgsConstructor
public class UserCoupon extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userCouponNum;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "merCouponNum")
	private MerCoupon merCoupon;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "memberId")
	private Member member;

	private boolean userCouponActive;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ocode")
	private OrderTb order;
	
}
