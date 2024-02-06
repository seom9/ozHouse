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

}
