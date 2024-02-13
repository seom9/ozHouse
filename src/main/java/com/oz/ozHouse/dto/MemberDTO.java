package com.oz.ozHouse.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.oz.ozHouse.domain.Member;
import com.oz.ozHouse.domain.OrderTb;
import com.oz.ozHouse.domain.common.Address;
import com.oz.ozHouse.domain.common.Image;
import com.oz.ozHouse.domain.common.MemberLevel;
import com.oz.ozHouse.domain.common.MemberRole;
import com.oz.ozHouse.domain.common.PhoneNumber;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO{
    private int memberNum;
    private String memberName;
    private String memberId;
    private String memberPasswd;
    private String memberNickname;
    private String memberEmail;
    private MemberRole memberRole;
    private Image memberImage;
    private Address memberAddress;
    private PhoneNumber memberHp;
    private List<OrderTb> orderList;
    private int memberPoint;
    private MemberLevel memberLevel;
    private LocalDate regDate;
    private LocalDate modDate;
    private LocalDate memberDeletedate;
 
    public MemberDTO withMemberPasswd(String passwd) {
        this.memberPasswd = passwd;
        return this;
    }
    
    public MemberDTO withMemberImage(Image image) {
        this.memberImage = image;
        return this;
    }
   
    // 엔티티를 DTO 로
    public MemberDTO(Member member) {
        this.memberNum = member.getMemberNum();
        this.memberName = member.getMemberName();
        this.memberId = member.getMemberId();
        this.memberPasswd = member.getMemberPasswd();
        this.memberNickname = member.getMemberNickname();
        this.memberEmail = member.getMemberEmail();
        this.memberImage = member.getMemberImage();
        this.memberAddress = member.getMemberAddress();
        this.memberHp = member.getMemberHp();
        this.orderList = member.getOrderList();
        this.memberPoint = member.getMemberPoint();
        this.memberLevel = member.getMemberLevel();
        this.regDate = member.getRegDate();
        this.modDate = member.getModDate();
        this.memberDeletedate = member.getMemberDeletedate();
    }
    
    public MemberDTO(HttpServletRequest req) {
        this.memberNum = Integer.parseInt(req.getParameter("memberNum"));
        this.memberName = req.getParameter("memberName");
        this.memberId = req.getParameter("memberId");
        this.memberPasswd = req.getParameter("memberPasswd");
        this.memberNickname = req.getParameter("memberNickname");
        this.memberEmail = req.getParameter("memberEmail");
        this.memberImage = new Image(req.getParameter(memberName), req.getParameter("memberImage"),
        		req.getParameter("memberImage"), req.getParameter("memberImage"));
        this.memberAddress = new Address(req.getParameter("postcode"), req.getParameter("city"), 
        					req.getParameter("street"), req.getParameter("zipcode"));
        this.memberHp = new PhoneNumber(req.getParameter("hp1"), req.getParameter("hp2"), req.getParameter("hp3"));
        // orderList, memberPoint, memberLevel, regDate, modDate, memberDeletedate 등은 HTTP 요청 파라미터에 따라 초기화하지 않음
        // 필요에 따라 추가적인 로직을 작성하여 초기화해야 함
    }
    
    // DTO를 엔티티로 변환하는 메서드
    public Member toEntity() {
        return Member.builder()
                .memberNum(this.memberNum)
                .memberName(this.memberName)
                .memberId(this.memberId)
                .memberPasswd(this.memberPasswd)
                .memberNickname(this.memberNickname)
                .memberEmail(this.memberEmail)
                .memberImage(this.memberImage)
                .memberAddress(this.memberAddress)
                .memberHp(this.memberHp)
                .orderList(this.orderList)
                .memberPoint(this.memberPoint)
                .memberLevel(this.memberLevel)
                .memberDeletedate(this.memberDeletedate)
                .build();
    }
    
}