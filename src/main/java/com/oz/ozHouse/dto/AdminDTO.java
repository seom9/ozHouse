package com.oz.ozHouse.dto;

import java.sql.Date;

import com.oz.ozHouse.domain.Admin;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AdminDTO {
	private int adminNum;
	private String adminId;
	private String adminPasswd;
	private String adminEmail;
	private String adminHp1;
	private String adminHp2;
	private String adminHp3;
	private Date adminJoinDate;
}
