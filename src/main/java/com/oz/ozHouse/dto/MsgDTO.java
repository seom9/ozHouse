package com.oz.ozHouse.dto;

import com.oz.ozHouse.domain.Msg; // Assuming there is a corresponding domain class

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MsgDTO {
    private int num;
    private String reason;
    private String approvalStatus;

    public Msg toEntity() {
        Msg msg = new Msg();
        msg.setNum(this.num);
        msg.setReason(this.reason);
        msg.setApprovalStatus(this.approvalStatus);
        return msg;
    }
}
