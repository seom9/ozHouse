package com.oz.ozHouse.domain.member;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.oz.ozHouse.domain.OrderTb;
import com.oz.ozHouse.domain.BaseEntity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
public class Member extends BaseEntity{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int memberNum;
	
	private String memberName;
	
	private String memberId;
	
	private String memberPasswd;
	
	private String memberNickname;
	
	private String memberEmail;
	
	private String memberImage;
	
	@Embedded
	private Address memberAddress;
	
	@Embedded
	private PhoneNumber memberHp;
	
    @OneToMany(mappedBy = "member")
    private List<OrderTb> orderList = new ArrayList<>();
	
	private int memberPoint;
	
	private String memberLevel;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yy/MM/dd")
	private Date memberJoindate;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yy/MM/dd")
	private Date memberDeletedate;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
	s
}
