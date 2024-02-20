package com.oz.ozHouse.dto.client.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberPasswdUpdateDTO {
	String memberId;
	String memberEmail;
	String memberPasswd;
	String newMemberPasswd;
	String userSendNum;
	String checkNum;
	String member;
}
