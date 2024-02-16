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
@Getter
public class ProductReQA {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productReQANum;
	private int productNum;
	private String memberId;
	private String productReQAContent;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String productReQADate;

}
