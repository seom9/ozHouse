package com.oz.ozHouse.domain;

import java.sql.Date;

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
import lombok.Setter;

@Entity
@Getter
public class UserCoupon {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userCouponNum;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="merCouponNum")
	private MerCoupon merCouponNum;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="memberNum")
	private Member memberNum;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="merchantNum")
	private Merchant merNum;
	
	private String userCouponActive;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yy/MM/dd")
	private Date merCouponEndDate;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="orderNum")
	private OrderTb orderCode;
}
