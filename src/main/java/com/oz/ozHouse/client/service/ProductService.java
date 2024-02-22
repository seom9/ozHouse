package com.oz.ozHouse.client.service;

import java.util.List;

import com.oz.ozHouse.domain.Product;
import com.oz.ozHouse.dto.ProductDTO;

public interface ProductService {
	
	List<ProductDTO> cliProductList();
	
	ProductDTO getProduct(Integer proNum);
}
