package com.oz.ozHouse.dto;

import java.time.LocalDate;

import com.oz.ozHouse.domain.AdminReQA;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor  //기본생성자 자동으로 생성
public class AdminReQADTO {
    private int adminReQANum;
    private String adminReQASubject;
    private String adminReQAContent;
    private LocalDate adminReQADate;

<<<<<<< HEAD
    public AdminReQADTO toDTO(AdminReQA adminReQA) {
		return AdminReQADTO.builder()
				.adminReQANum(adminReQA.getAdminReQANum())
				.adminReQASubject(adminReQA.getAdminReQASubject())
				.adminReQAContent(adminReQA.getAdminReQAContent())
				.adminReQADate(adminReQA.getAdminReQADate())
				.build();
	}
=======
>>>>>>> branch 'main' of https://github.com/gahyunseoul/ozHouse.git
}
