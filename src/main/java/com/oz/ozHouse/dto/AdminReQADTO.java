package com.oz.ozHouse.dto;

import java.sql.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.oz.ozHouse.domain.AdminReQA; // Assuming there is a corresponding domain class

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AdminReQADTO {
    private int adminReQANum;
    private String adminReQASubject;
    private String adminReQAContent;
    private Date adminReQADate;

    public AdminReQA toEntity() {
        AdminReQA adminReQA = new AdminReQA();
        adminReQA.setAdminReQANum(this.adminReQANum);
        adminReQA.setAdminReQASubject(this.adminReQASubject);
        adminReQA.setAdminReQAContent(this.adminReQAContent);
        adminReQA.setAdminReQADate(this.adminReQADate);
        return adminReQA;
    }
}
