package com.oz.ozHouse.domain;

import com.oz.ozHouse.domain.common.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Entity
@Getter
public class Scrap extends BaseEntity {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int scrapNum;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
	private Member member;
	    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productNum")
    private Product product;
}
