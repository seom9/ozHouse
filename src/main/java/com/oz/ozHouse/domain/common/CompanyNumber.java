package com.oz.ozHouse.domain.common;

import com.oz.ozHouse.dto.MerchantDTO;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Builder
@NoArgsConstructor   //기본 생성자 자동 생성
@AllArgsConstructor  //필드의 모든 값을 초기화하는 생성자 자동 생성
@Getter
public class CompanyNumber {
	public String merComnum1;
	public String merComnum2;
	public String merComnum3;
	
	public CompanyNumber toEntity(MerchantDTO dto) {
		return CompanyNumber.builder()
			.merComnum1(dto.getMerComnum1())
			.merComnum2(dto.getMerComnum2())
			.merComnum3(dto.getMerComnum3())
			.build();
	}
}
