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
public class Inbrand {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int inNum;
	private int merNum;
	private String inCompany;
	private String inComnum1;
	private String inComnum2;
	private String inComnum3;
	private String inHomepage;
	private String inManname;
	private String inManhp1;
	private String inManhp2;
	private String inManhp3;
	private String inManemail;
	private String inCategory;
	private String inOthershop;
	private String inSalefile;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yy/MM/dd")
	private Date inAppliDate;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yy/MM/dd")
	private Date inCancelDate;
	
}
