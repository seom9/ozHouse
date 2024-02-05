package com.oz.ozHouse.domain.common;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ProPrice {
	private int proPrice;
	private int proPoint;	
	private int proAssemblyCost;
	private int proDiscountRate;
}
