package com.oz.ozHouse.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Entity
@Getter
public class MerCoupon {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int merCouponnum;
	private String merCouponname;
	private String merIsok;
	private int merCoupondiscount;
	
	@ManyToOne
	@JoinColumn(name = "merNum")
	private Merchant merNum;
	
    @OneToMany(mappedBy = "merCoupon", cascade = CascadeType.ALL)
    private List<UserCoupon> userCoupons = new ArrayList<>();
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private Member member;

	@DateTimeFormat(pattern = "yy/MM/dd")
	private LocalDate merCouponusedate;
	
	@DateTimeFormat(pattern = "yy/MM/dd")
	private LocalDate merCouponenddate;
	
}
