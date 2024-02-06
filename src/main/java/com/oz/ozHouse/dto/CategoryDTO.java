package com.oz.ozHouse.dto;

import java.time.LocalDate;

import com.oz.ozHouse.domain.Category; // Assuming there is a corresponding domain class

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor   //기본생성자 자동으로 생성
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

    public CategoryDTO toDTO(Category category) {
    	return CategoryDTO.builder()
    			.categoryNum(category.getCategoryNum())
    			.categoryCode(category.getCategoryCode())
    			.categoryName(category.getCategoryName())
    			.build();
    }
}
