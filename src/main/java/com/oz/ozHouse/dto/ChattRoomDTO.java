package com.oz.ozHouse.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.oz.ozHouse.domain.ChattRoom;
import com.oz.ozHouse.domain.Member;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor // 기본생성자 자동으로 생성
public class ChattRoomDTO {
	private int roomNum;
	private String myId;
	private String otherId;
	private String createTime;
	private int proNum;
	private String myIdCheck; 
    private String otherIdCheck;
    private String partner;
    private String lastMessage; 

    
    public ChattRoomDTO(int roomNum, String partner, String lastMessage) {
        this.roomNum = roomNum;
        this.partner = partner;
        this.lastMessage = lastMessage;
    }
    
	public static ChattRoomDTO toDTO(ChattRoom dto) {
		
		return ChattRoomDTO.builder()
		.roomNum(dto.getRoomNum())
		.myId(dto.getMyId())
		.otherId(dto.getOtherId())
		.createTime(dto.getCreateTime())
//		.proNum(dto.getOzPro().getProNum())
		.proNum(dto.getProNum())
		.myIdCheck(dto.getMyIdCheck())
		.otherIdCheck(dto.getOtherIdCheck())
		.build();
		
	}

	public ChattRoomDTO(HttpServletRequest req) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy/MM/dd");

		this.myId = req.getParameter("myId");
		this.otherId = req.getParameter("otherId");
		this.createTime = LocalDate.now().format(formatter);
		this.proNum = Integer.parseInt(req.getParameter("proNum"));
		this.myIdCheck = req.getParameter("myIdCheck");
		this.otherIdCheck = req.getParameter("otherIdCheck");
	}
	
	public void setMyId(String myId) {
        this.myId = myId;
    }
    
    public void setOtherId(String otherId) {
    	this.otherId = otherId;
    }

    public void setProNum(Integer proNum) {
        this.proNum = proNum;
    }
    
    public void setPartner(String partner) {
    	this.partner = partner;
    }
}
