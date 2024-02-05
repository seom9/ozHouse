package com.oz.ozHouse.domain.common;

import java.util.ArrayList;
import java.util.List;

import com.oz.ozHouse.domain.Category;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class InbrandInfo {

	private String homepage;
	private String ManagerName;
	
	@Embedded
	private PhoneNumber phoneNum;
	
	private String ManagerEmail;
	
//	@ElementCollection
//	private List<Category> category = new ArrayList<Category>();
	private String category;
	 
	private String otherShop;
	
	private String brandFile;
	
	
}
