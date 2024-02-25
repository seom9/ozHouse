package com.oz.ozHouse.dto.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor  
public class ProPriceDTO {
	private int proPrice;
	private int proPoint;	
	private int proAssemblyCost;
	private int proDiscountRate;
	private int proDiscountPrice;
}
