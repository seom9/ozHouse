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
@Setter
@Getter
public class Inbrand {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int inNum;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "merNum")
	private Merchant merchant;

	private String inCompany;
	
	private String inComnum;

	private String inHomepage;

	private String inManname;
	
	private String inManHp;

	private String inManemail;

	private String inCategory;

	private String inOthershop;

	private String inSaleFile;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yy/MM/dd")
	private Date inAppliDate;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yy/MM/dd")
	private Date inCancelDate;
}
