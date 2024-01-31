package com.oz.ozHouse.domain;

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
public class ProductQA {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productQANum;
	private int productNum;
	private String memberId;
	private String productQASubject;
	private String productQAContent;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String productQADate;
	private int productReLevel;
	private int productReStep;
	private String productInquiryType;
	private String productQAState;
}
