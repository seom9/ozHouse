package com.oz.ozHouse.dto.merchant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MerProOrderDTO {
	private String proName;
	private int proNum;
	private int quantity;
	private int realPrice;
	private String oRefund;
}
