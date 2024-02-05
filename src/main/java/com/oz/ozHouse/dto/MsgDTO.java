package com.oz.ozHouse.dto;


import com.oz.ozHouse.domain.Msg; // Assuming there is a corresponding domain class

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor   //기본생성자 자동으로 생성
public class MsgDTO {
    private int num;
    private String reason;
    private String approvalStatus;

<<<<<<< HEAD
    public MsgDTO toDTO(Msg msg) {
    	return MsgDTO.builder()
    			.num(msg.getNum())
    			.reason(msg.getReason())
    			.approvalStatus(msg.getApprovalStatus())
    			.build();
    }
=======

>>>>>>> branch 'main' of https://github.com/gahyunseoul/ozHouse.git
}
