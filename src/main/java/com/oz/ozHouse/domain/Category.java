package com.oz.ozHouse.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryNum;
	
	private String categoryCode;
	private String categoryName;
}
