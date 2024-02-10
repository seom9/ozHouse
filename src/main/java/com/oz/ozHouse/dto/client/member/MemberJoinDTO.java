package com.oz.ozHouse.dto.client.member;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberJoinDTO {
	private String memberId;
	private String memberPasswd;
    private String memberNickname;
    private String memberEmail;
    private LocalDate memberDeleteDate;
    private boolean social;
}
