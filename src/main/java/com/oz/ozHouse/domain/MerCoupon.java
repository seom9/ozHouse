package com.oz.ozHouse.domain;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
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
	private int merNum;
	
	@DateTimeFormat(pattern = "yy/MM/dd")
	private LocalDate merCouponusedate;
	
	@DateTimeFormat(pattern = "yy/MM/dd")
	private LocalDate merCouponenddate;
	
}
