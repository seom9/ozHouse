package com.oz.ozHouse.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//import com.oz.ozHouse.domain.Chatt;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor // 기본생성자 자동으로 생성
public class ChattDTO {
	public enum MessageType {
        ENTER, TALK,QUIT
    }
	private MessageType type;
	private int msgNum;
//	private int proNum;
	private String recipient;
	private String sender;
	private String msg;
//	private int readStatus;
	private int roomNum;
	private String inTime;
	
//	public ChattDTO toDTO(Chatt chatt) {
//		
//		return ChattDTO.builder()
//				.msgNum(chatt.getMsgNum())
////				.proNum(chatt.getOzMarketPro().getProNum())
////				.proNum(chatt.getProNum())
//				.recipient(chatt.getRecipient())
//				.sender(chatt.getSender())
//				.msg(chatt.getMsg())
////				.readStatus(chatt.getReadStatus())
////				.file(chatt.getFile())
//				.roomNum(chatt.getChattRoom().getRoomNum())
////				.roomNum(chatt.getRoomNum())
//				.inTime(chatt.getInTime())
//				.build();
//	}
	
	public ChattDTO(HttpServletRequest req) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss");
		
//		this.msgNum = Integer.parseInt(req.getParameter("msgNum"));
//		this.proNum = Integer.parseInt(req.getParameter("proNum"));
		this.recipient = req.getParameter("recipient");
		this.sender = req.getParameter("sender");
		this.msg = req.getParameter("msg");
//		this.readStatus = req.getParameter("readStatus");
//		this.readStatus = Integer.parseInt(req.getParameter("readStatus"));
//		this.readStatus = 2;
		this.roomNum = Integer.parseInt(req.getParameter("roomNum"));
		this.inTime = LocalDateTime.now().format(formatter);
	}
	
	
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public void setSender(String sender) {
		this.sender = sender;
	}
	
	public void setType(MessageType type) {
		this.type = type;
	}
	
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	
//	public void setReadStatus(int readStatus) {
//		this.readStatus = readStatus;
//	}
}
