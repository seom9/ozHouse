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
public class OrderReQA {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int order_reQA_num ;
	private String member_id;
	private String order_reQA_content;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yy/MM/dd")
	private String order_reQA_date;

}
