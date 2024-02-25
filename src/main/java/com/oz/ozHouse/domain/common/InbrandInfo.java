package com.oz.ozHouse.domain.common;

import java.util.List;

import com.oz.ozHouse.domain.Category;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class InbrandInfo {

	private String homepage;
	private String ManagerName;
	
	@Embedded
	private PhoneNumber phoneNum;
	
	private String ManagerEmail;
	
	@Column
	@ElementCollection(fetch = FetchType.EAGER)
	@Enumerated(EnumType.STRING)
	private List<Category> category;
	 
	private String otherShop;
	
	private String brandFile;
}