package com.oz.ozHouse.merchant.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oz.ozHouse.domain.Product;
import com.oz.ozHouse.dto.ProductDTO;

@Service
public interface MerProService {
	
	//상품 등록
	public String insertProduct(ProductDTO dto);
	
	//재고리스트
	public List<ProductDTO> stockList();
	
	//재고리스트 건수
	public Long stockListCount();

	public void updateProductStock(Integer proNum, Integer newQuantity);

}
