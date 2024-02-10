package com.oz.ozHouse.merchant.config;

import com.oz.ozHouse.dto.MerchantDTO;
import com.oz.ozHouse.merchant.service.MerLoginService;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MerchantLoginBean {
	private int merNum;
	private String merId;
	private String merPw;
	private String merIsbrand;
	private String merCompany;
	
	public static final int OK = 0;
	public static final int NOT_ID = 1;
	public static final int NOT_PW = 2;
	public static final int ERROR = -1;
	public static final int DELETE_ID = -2;
	
	public int loginOk(MerLoginService loginService) {
		try {
			MerchantDTO dto = loginService.merchant_getMember(merId);
			if (dto != null) {
				if(dto.getMerDelete() == null && dto.getMerPw().trim().equals(merPw)) {
					merNum = dto.getMerNum();
					merIsbrand = dto.getMerIsbrand();
					merCompany = dto.getMerCompany();
					return OK;
				}else if (dto.getMerDelete() != null) { 
					return DELETE_ID;
				}else {
					return NOT_PW;
				}
			}else {
				return NOT_ID;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
}
