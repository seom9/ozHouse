package com.oz.ozHouse.domain;

import com.oz.ozHouse.domain.common.BaseEntity;
import com.oz.ozHouse.domain.common.PhoneNumber;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Admin extends BaseEntity{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminNum;
	
	private String adminId;
	
	private String adminPasswd;
	
	private String adminEmail;
	
	@Embedded
	private PhoneNumber adminHp;
}
