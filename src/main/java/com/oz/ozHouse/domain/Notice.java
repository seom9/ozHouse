package com.oz.ozHouse.domain;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Notice {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int noticeNum;
	
	private String noticeTitle;
	
	private String noticeContent;
	
	@DateTimeFormat(pattern = "yy/MM/dd")	
	private LocalDate noticeDate;
}
