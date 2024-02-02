package com.oz.ozHouse.dto;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.oz.ozHouse.domain.member.Member;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberDTO {
	private int memberNum;
	private String memberName;
	private String memberId;
	private String memberPasswd;
	private String memberNickname;
	private String memberEmail;
	private String memberImage;
	private String memberAddress1;
	private String memberAddress2;
	private String memberAddress3;
	private String memberPostcode1;
	private String memberPostcode2;
	private String memberPostcode3;
	private String memberHp1;
	private String memberHp2;
	private String memberHp3;
	private int memberPoint;
	private String memberLevel;
	private Date memberJoindate;
	private Date memberDeletedate;
}
