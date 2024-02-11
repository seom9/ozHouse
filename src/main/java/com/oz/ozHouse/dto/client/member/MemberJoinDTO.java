package com.oz.ozHouse.dto.client.member;

import java.beans.ConstructorProperties;
import java.time.LocalDate;

import lombok.Getter;

@Getter
public class MemberJoinDTO {
    private String memberId;
    private String memberPasswd;
    private String memberNickname;
    private String memberEmail;
    private LocalDate memberDeleteDate;
    private boolean social;

    @ConstructorProperties({"memberId", "memberPasswd", "memberNickname", "memberEmail", "memberDeleteDate", "social"})
    public MemberJoinDTO(String memberId, String memberPasswd, String memberNickname, String memberEmail, LocalDate memberDeleteDate, boolean social) {
        this.memberId = memberId;
        this.memberPasswd = memberPasswd;
        this.memberNickname = memberNickname;
        this.memberEmail = memberEmail;
        this.memberDeleteDate = memberDeleteDate;
        this.social = social;
    }
}
