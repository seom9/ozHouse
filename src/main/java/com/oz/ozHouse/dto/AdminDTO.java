package com.oz.ozHouse.dto;

import java.sql.Date;

import com.oz.ozHouse.domain.Admin;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AdminDTO {
	private int adminNum;
	private String adminId;
	private String adminPasswd;
	private String adminEmail;
	private String adminHp1;
	private String adminHp2;
	private String adminHp3;
	private Date adminJoinDate;

    public Admin toEntity() {
        Admin admin = new Admin();
        admin.setAdminNum(this.adminNum);
        admin.setAdminId(this.adminId);
        admin.setAdminPasswd(this.adminPasswd);
        admin.setAdminEmail(this.adminEmail);
        admin.setAdminHp1(this.adminHp1);
        admin.setAdminHp2(this.adminHp2);
        admin.setAdminHp3(this.adminHp3);
        admin.setAdminJoinDate(this.adminJoinDate);
        return admin;
    }
}
