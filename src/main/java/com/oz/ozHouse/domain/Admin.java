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
public class Admin {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminNum;
	private String adminId;
	private String adminPasswd;
	private String adminEmail;
	private String adminHp1;
	private String adminHp2;
	private String adminHp3;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yy/MM/dd")
	private Date adminJoinDate;
}
