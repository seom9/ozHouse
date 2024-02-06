package com.oz.ozHouse.domain.common;

import java.util.ArrayList;
import java.util.List;

import com.oz.ozHouse.domain.Category;
import com.oz.ozHouse.dto.CategoryDTO;

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
	
	@ElementCollection
	private List<Category> category = new ArrayList<Category>();
	 
	private String otherShop;
	
	private String brandFile;
	
	//List Collection Entity -> DTO로 변환 메소드
	public List<CategoryDTO> getCategoryDto(){
		List<CategoryDTO> list = new ArrayList<CategoryDTO>();
		for(Category c : this.category) {
			CategoryDTO dto = new CategoryDTO();
			dto.toDTO(c);
			list.add(dto);
		}
		return list;
	}
}