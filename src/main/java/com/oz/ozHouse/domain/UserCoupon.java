package com.oz.ozHouse.domain;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;

@Entity
@Getter
public class UserCoupon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userCouponNum;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "merCouponNum")
	private MerCoupon merCoupon;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "memberNum")
	private Member member;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "merNum")
	private Merchant merchant;

	private String userCouponActive;

	@DateTimeFormat(pattern = "yy/MM/dd")
	private LocalDate merCouponEndDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ocode")
	private OrderTb orderCode;
}
