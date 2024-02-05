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
public class AdminQA {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminQANum;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "memberId")
	private Member member;
	
	private String adminQASubject;
	private String adminQAContent;
	private String admininquiryType;
	private String adminQAState;	
	
	@DateTimeFormat(pattern = "yy/MM/dd")	
	private LocalDate adminQADate;
	
}
