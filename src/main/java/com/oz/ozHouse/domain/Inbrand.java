package com.oz.ozHouse.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.oz.ozHouse.domain.common.PhoneNumber;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	
	@Embedded
	private PhoneNumber inComnum;

	private String inHomepage;
	
    @OneToMany(mappedBy = "inbrand", cascade = CascadeType.REMOVE)
    private List<Product> productList = new ArrayList<>();
    
	private String inManname;
	
	@Embedded
	private PhoneNumber inManHp;

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
	
	int num = 0;
}
