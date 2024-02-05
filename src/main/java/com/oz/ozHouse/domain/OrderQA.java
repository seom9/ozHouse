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
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderQA {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderQANum ;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "memberId")
	private Member member;
	
	private String orderQAContent;
	private String orderInquiryType;
	private String orderQAState;
	
	@DateTimeFormat(pattern = "yy/MM/dd")
	private LocalDate orderQADate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orderNum")
	private OrderTb ordertb;
}
