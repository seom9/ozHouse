package com.oz.ozHouse.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MypagePointDTO {
	long order_code;
	String order_date;
	String statement;
	int point;
}
