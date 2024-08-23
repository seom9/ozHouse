package com.oz.ozHouse.dto.merchant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder(toBuilder = true)
@Getter
@AllArgsConstructor
@NoArgsConstructor 
public class ProinformDTO {

	private int proInNum;
	private int proNum;
	private String proName;
	private int quantity;
	private String oRefund;
	private int realPrice;
	
}
