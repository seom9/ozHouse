package com.oz.ozHouse.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.oz.ozHouse.dto.ChattRoomDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "ChattRoom")
@Builder(toBuilder = true)
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ChattRoom {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roomNum;

	private String myId; // 방을 만든 사람

	private String otherId; // 대화상대

	private String createTime;

//    @ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "proNum")
//    private OzMarketPro ozPro;

	private int proNum;

	private String myIdCheck;

	private String otherIdCheck;
	
	@Transient
	private String partner;

	public ChattRoom(ChattRoomDTO dto) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy/MM/dd");

//		this.roomNum = dto.getRoomNum();
		this.myId = dto.getMyId();
		this.otherId = dto.getOtherId();
		if (dto.getCreateTime() != null) {
			this.createTime = dto.getCreateTime().formatted(formatter);
		} else {
			this.createTime = LocalDate.now().format(formatter); // 기본값으로 현재 날짜 설정
		}
		this.proNum = dto.getProNum();
		this.myIdCheck = "off";
		this.otherIdCheck = "off";
	}

}
