package com.oz.ozHouse.dto;

import java.time.LocalDate;
import com.oz.ozHouse.domain.AdminQA;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor  // 기본 생성자 자동으로 생성
public class AdminQADTO {
    private int adminQANum;
    private String memberId;
    private String adminQASubject;
    private String adminQAContent;
    private LocalDate adminQADate;
    private String admininquiryType;
    private String adminQAState;
    
    public AdminQADTO toDTO(AdminQA adminQA) {
        return AdminQADTO.builder()
                .adminQANum(adminQA.getAdminQANum())
                .adminQASubject(adminQA.getAdminQASubject())
                .adminQAContent(adminQA.getAdminQAContent())
                .admininquiryType(adminQA.getAdmininquiryType())
                .adminQAState(adminQA.getAdminQAState())
                .adminQADate(adminQA.getAdminQADate())
                .build();
    }
}
