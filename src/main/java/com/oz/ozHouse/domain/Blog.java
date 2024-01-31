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
public class Blog {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int blogNum;
	private String memberId;
	private String blogSubject;
	private String blogContent;
	private String blogImage;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String blogDate;
	private String blogRoomType;
	private int readcount;
}
