package com.oz.ozHouse.domain;

import com.oz.ozHouse.domain.common.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@IdClass(ScrapId.class)
public class Scrap extends BaseEntity {
	
    @Id
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
	private Member member;
	
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productNum")
    private Product product;
}
