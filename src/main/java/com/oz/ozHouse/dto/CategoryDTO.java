package com.oz.ozHouse.dto;

import com.oz.ozHouse.domain.Category; // Assuming there is a corresponding domain class

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDTO {
    private int categoryNum;
    private String categoryCode;
    private String categoryName;

    public Category toEntity() {
        Category category = new Category();
        category.setCategoryNum(this.categoryNum);
        category.setCategoryCode(this.categoryCode);
        category.setCategoryName(this.categoryName);
        return category;
    }
}
