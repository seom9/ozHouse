package com.oz.ozHouse.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Member {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	private String memberJoindate;
	private String memberDeletedate;
}
