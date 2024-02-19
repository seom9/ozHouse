package com.oz.ozHouse.merchant.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import com.oz.ozHouse.domain.Product;
import com.oz.ozHouse.dto.ProductDTO;
import com.oz.ozHouse.dto.RequestProductDTO;

@NoRepositoryBean
public interface MerProductRepository extends Repository<Product, Integer> {

	// 전체 상품 현황
	Long allCount(Integer merNum);

	// 승인 대기 현황
	Long waitCount(Integer merNum);

	// 승인 보류 현황
	Long requestCount(Integer merNum);

	// 승인 반려 현황
	Long cancleCount(Integer merNum);

	// 요청 취소 현황
	Long requestCancle(Integer merNum);

	// 판매중 현황
	Long saleOk(Integer merNum);

	// 상품 등록
	Product save(Product product);

	// 상품 상세보기
	Optional<ProductDTO> findByProNum(Integer proNum);

//	// 수정 상품 상세보기
//	Optional<RequestProductDTO> findRequestByProNum(Integer proNum);

	// 조회 리스트
	List<ProductDTO> listProduct(Map<String, Object> params);

	// 조회 리스트 건수
	Long listCount(Map<String, Object> params);

	// 요청리스트
	List<ProductDTO> requestList(Map<String, Object> params);

	// 요청리스트 건수
	Long requestListCount(Map<String, Object> params);

	// 재고 리스트
	List<ProductDTO> stockList(Map<String, Object> params);

	// 재고 리스트 건수
	Long stockListCount(Map<String, Object> params);

	// 재고 수정
	Optional<Product> findById(Integer proNum);

}
