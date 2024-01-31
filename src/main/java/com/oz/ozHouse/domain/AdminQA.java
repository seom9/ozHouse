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
public class AdminQA {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminQANum;
	private String memberId;
	private String adminQASubject;
	private String adminQAContent;
	private String admininquiryType;
	private String adminQAState;	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yy/MM/dd")	
	private Date adminQADate;
}
