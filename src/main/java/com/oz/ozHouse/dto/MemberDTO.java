package com.oz.ozHouse.dto;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.oz.ozHouse.domain.Member;
import com.oz.ozHouse.domain.OrderTb;
import com.oz.ozHouse.domain.common.Address;
import com.oz.ozHouse.domain.common.BaseEntity;
import com.oz.ozHouse.domain.common.MemberLevel;
import com.oz.ozHouse.domain.common.PhoneNumber;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberDTO{
    private int memberNum;
    private String memberName;
    private String memberId;
    private String memberPasswd;
    private String memberNickname;
    private String memberEmail;
    private String memberImage;
    private Address memberAddress;
    private PhoneNumber memberHp;
    private List<OrderTb> orderList;
    private int memberPoint;
    private MemberLevel memberLevel;
    private LocalDate regDate;
    private LocalDate modDate;
    private LocalDate memberDeletedate;
    
    public static MemberDTO fromEntity(Member member) {
        MemberDTO dto = new MemberDTO();
        dto.setMemberNum(member.getMemberNum());
        dto.setMemberName(member.getMemberName());
        dto.setMemberId(member.getMemberId());
        dto.setMemberPasswd(member.getMemberPasswd());
        dto.setMemberNickname(member.getMemberNickname());
        dto.setMemberEmail(member.getMemberEmail());
        dto.setMemberImage(member.getMemberImage());
        dto.setMemberAddress(member.getMemberAddress());
        dto.setMemberHp(member.getMemberHp());
        dto.setOrderList(member.getOrderList());
        dto.setMemberPoint(member.getMemberPoint());
        dto.setMemberLevel(member.getMemberLevel());
        dto.setRegDate(member.getRegDate());
        dto.setModDate(member.getModDate());
        dto.setMemberDeletedate(member.getMemberDeletedate());
        return dto;
    }
}