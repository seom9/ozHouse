package com.oz.ozHouse.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.oz.ozHouse.domain.common.Address;
import com.oz.ozHouse.domain.common.BaseEntity;
import com.oz.ozHouse.domain.common.MemberLevel;
import com.oz.ozHouse.domain.common.PhoneNumber;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
	
    @OneToMany(mappedBy = "memberId")
    private List<OrderTb> orderList = new ArrayList<>();
	
	private int memberPoint;
	
    @Enumerated(EnumType.STRING)
    private MemberLevel memberLevel;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yy/MM/dd")
	private Date memberDeletedate;
	
    @Builder
    public Member(int memberNum, String memberName, String memberId, String memberPasswd, 
    				String memberNickname, String memberEmail, String memberImage, 
    				Address memberAddress, PhoneNumber memberHp, List<OrderTb> orderList, 
    				int memberPoint, MemberLevel memberLevel, Date memberDeletedate) {
        this.memberNum = memberNum;
        this.memberName = memberName;
        this.memberId = memberId;
        this.memberPasswd = memberPasswd;
        this.memberNickname = memberNickname;
        this.memberEmail = memberEmail;
        this.memberImage = memberImage;
        this.memberAddress = memberAddress;
        this.memberHp = memberHp;
        this.orderList = orderList;
        this.memberPoint = memberPoint;
        this.memberLevel = memberLevel;
        this.memberDeletedate = memberDeletedate;
    }
}
	
