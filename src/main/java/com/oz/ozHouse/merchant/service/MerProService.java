package com.oz.ozHouse.merchant.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.oz.ozHouse.dto.ProductDTO;
import com.oz.ozHouse.dto.RequestProductDTO;

@Service
public interface MerProService {

	// 상품 등록
	public String insertProduct(ProductDTO dto);

	// 상품 상세보기
	ProductDTO getProduct(Integer proNum);

	// 수정 상품 상세보기
//	public RequestProductDTO getreProduct(String proNum);

	// 조회리스트
	public List<ProductDTO> listProduct(Map<String, Object> params);

	// 조회리스트 건수
	public Long listCount(Map<String, Object> params);

	// 요청리스트
	public List<ProductDTO> requestList(Map<String, Object> params);

	// 요청리스트 건수
	public Long requestListCount(Map<String, Object> params);

	// 재고리스트
	public List<ProductDTO> stockList(Map<String, Object> params);

	// 재고리스트 건수
	public Long stockListCount(Map<String, Object> params);

	// 재고 수정
	boolean updateProductStock(Map<String, Object> params);
}
