package com.oz.ozHouse.dto;

import com.oz.ozHouse.domain.Member;

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
	private String memberJoindate;
	private String memberDeletedate;
	
   public Member toEntity() {
        Member member = new Member();
        member.setMemberNum(this.memberNum);
        member.setMemberName(this.memberName);
        member.setMemberId(this.memberId);
        member.setMemberPasswd(this.memberPasswd);
        member.setMemberNickname(this.memberNickname);
        member.setMemberEmail(this.memberEmail);
        member.setMemberImage(this.memberImage);
        member.setMemberAddress1(this.memberAddress1);
        member.setMemberAddress2(this.memberAddress2);
        member.setMemberAddress3(this.memberAddress3);
        member.setMemberPostcode1(this.memberPostcode1);
        member.setMemberPostcode2(this.memberPostcode2);
        member.setMemberPostcode3(this.memberPostcode3);
        member.setMemberHp1(this.memberHp1);
        member.setMemberHp2(this.memberHp2);
        member.setMemberHp3(this.memberHp3);
        member.setMemberPoint(this.memberPoint);
        member.setMemberLevel(this.memberLevel);
        member.setMemberJoindate(this.memberJoindate);
        member.setMemberDeletedate(this.memberDeletedate);
        return member;
    }
}
