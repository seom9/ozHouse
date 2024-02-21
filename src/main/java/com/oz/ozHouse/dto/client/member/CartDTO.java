package com.oz.ozHouse.dto.client.member;

import com.oz.ozHouse.dto.ProductDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {
    private ProductDTO productDTO;
    private int quantity;
}
