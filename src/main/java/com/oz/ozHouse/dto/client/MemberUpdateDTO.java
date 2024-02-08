package com.oz.ozHouse.dto.client;

import java.time.LocalDate;
import java.util.List;

import com.oz.ozHouse.domain.Member;
import com.oz.ozHouse.domain.OrderTb;
import com.oz.ozHouse.domain.common.Address;
import com.oz.ozHouse.domain.common.Image;
import com.oz.ozHouse.domain.common.MemberLevel;
import com.oz.ozHouse.domain.common.PhoneNumber;
import com.oz.ozHouse.dto.MemberDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberUpdateDTO {
	private Image memberImage;
	private String memberNickname;
	private PhoneNumber memberHp;
	private Address memberAddress;
	
	public Member updateEntity(Member member, MemberUpdateDTO updateDTO) {
		return member.toBuilder()
	        .memberImage(updateDTO.getMemberImage())
	        .memberNickname(updateDTO.getMemberNickname())
	        .memberAddress(updateDTO.getMemberAddress())
	        .memberHp(updateDTO.getMemberHp())
	        .build();
	}

}
