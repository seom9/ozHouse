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
public class DeliverySearchDTO {
	private String merNum;
	private String mode;  //배송상태
	private String startDate;
	private String endDate;
	private String search;
	private String searchString;
}
