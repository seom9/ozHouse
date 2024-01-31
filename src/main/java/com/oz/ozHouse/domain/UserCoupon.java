package com.oz.ozHouse.domain;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class UserCoupon {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userCouponNum;
	private int merCouponNum;
	private int memberNum;
	private int merNum;
	private String userCouponActive;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yy/MM/dd")
	private Date merCouponEndDate;
	private long orderCode;
}
