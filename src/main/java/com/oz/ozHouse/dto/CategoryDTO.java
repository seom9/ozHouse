package com.oz.ozHouse.dto;

import com.oz.ozHouse.domain.Category; // Assuming there is a corresponding domain class

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    private int categoryNum;
    private String categoryCode;
    private String categoryName;
    
    public CategoryDTO toDto(Category c) {
    	return CategoryDTO.builder()
    			.categoryNum(c.getCategoryNum())
    			.categoryCode(c.getCategoryCode())
    			.categoryName(c.getCategoryName())
    			.build();
    }

}
