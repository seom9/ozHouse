package com.oz.ozHouse.dto;

import java.sql.Date;

import com.oz.ozHouse.domain.Scrap;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ScrapDTO {
	private int scrapNum;
	private int memberNum;
	private int proNum;
	private Date scarpDate;
	
    public Scrap toEntity() {
        Scrap scrap = new Scrap();
        scrap.setScrapNum(this.scrapNum);
        scrap.setMemberNum(this.memberNum);
        scrap.setProNum(this.proNum);
        scrap.setScarpDate(this.scarpDate);
        return scrap;
    }
}
