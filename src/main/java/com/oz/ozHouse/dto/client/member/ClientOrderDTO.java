package com.oz.ozHouse.dto.client.member;

import java.beans.ConstructorProperties;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.oz.ozHouse.domain.Member;
import com.oz.ozHouse.domain.OrderTb;
import com.oz.ozHouse.domain.ProInform;
import com.oz.ozHouse.domain.UserCoupon;
import com.oz.ozHouse.domain.common.Address;
import com.oz.ozHouse.domain.common.PhoneNumber;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class ClientOrderDTO {	
	private int oDisPoint;
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
	
	public static OrderTb createNewOrder(ClientOrderDTO dto, Member member) {
		if (dto == null) return null;
		
        Address address = new Address(dto.getPostcode(), dto.getCity(), dto.getStreet(), dto.getZipcode());
        PhoneNumber phoneNumber = new PhoneNumber(dto.getPhoneNumber1(), dto.getPhoneNumber2(), dto.getPhoneNumber3());
        
    	LocalDateTime localDateTime = LocalDateTime.now();
    	String to = Integer.toString(member.getMemberNum()) + localDateTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        Long oNum = Long.parseLong(to);
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy/MM/dd");
        String regDate = localDateTime.format(formatter);
        
		return OrderTb.builder()
				.oNum(oNum)
				.member(member)
				.oDispoint((dto.getODisPoint() >= 0) ? dto.getODisPoint() : 0)
				.oPrice(dto.getOPrice())
				.oName(dto.getOName())
				.oHp(phoneNumber)
				.ostatus("ok")
				.oDelnow("ready")
				.oAddress(address)
				.oComment(dto.oComment)
				.regDate(regDate)
				.build();
	}
	
    @ConstructorProperties({"oDisPoint", "oPrice", "oName", "phoneNumber1", "phoneNumber2", "phoneNumber3", 
        "postcode", "city", "street", "zipcode", "oComment"})
	public ClientOrderDTO(int oDisPoint, int oPrice, String oName, String phoneNumber1, String phoneNumber2,
	      String phoneNumber3, String postcode, String city, String street, String zipcode,
	      String oComment) {
		this.oDisPoint = oDisPoint;
		this.oPrice = oPrice;
		this.oName = oName;
		this.phoneNumber1 = phoneNumber1;
		this.phoneNumber2 = phoneNumber2;
		this.phoneNumber3 = phoneNumber3;
		this.postcode = postcode;
		this.city = city;
		this.street = street;
		this.zipcode = zipcode;
		this.oComment = oComment;
	}
}
