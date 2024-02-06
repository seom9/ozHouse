package com.oz.ozHouse.dto;

import java.sql.Date;

import com.oz.ozHouse.domain.AdminQA;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AdminQADTO {
	private int adminQANum;
	private String memberId;
	private String adminQASubject;
	private String adminQAContent;
	private Date adminQADate;
	private String admininquiryType;
	private String adminQAState;

}
