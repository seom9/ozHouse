package com.oz.ozHouse.dto.client.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientOrderDTO {
	private int oDisPoint;
	private int oDisCoupont;
	private int oPrice;
	private String oName;
	
	public String phoneNumber1;
	public String phoneNumber2;
	public String phoneNumber3;
	
    private String postcode;
    private String city;
    private String street;
    private String zipcode;
    
	private String oComment;
}
