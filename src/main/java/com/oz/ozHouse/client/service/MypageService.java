package com.oz.ozHouse.client.service;

import com.oz.ozHouse.dto.client.member.MemberPasswdUpdateDTO;

public interface MypageService {
	
	// 비밀번호 업데이트
	boolean passUpdate(MemberPasswdUpdateDTO dto);
	
	boolean renewPass(MemberPasswdUpdateDTO dto);

}
