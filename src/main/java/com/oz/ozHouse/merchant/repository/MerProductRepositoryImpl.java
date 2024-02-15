package com.oz.ozHouse.merchant.repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import jakarta.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.oz.ozHouse.domain.Product;
import com.oz.ozHouse.dto.ProductDTO;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MerProductRepositoryImpl implements MerProductRepository{

	private final EntityManager em;
	

	//전체 상품 현황
	@Override
	public Long allCount() {
		return em.createQuery("SELECT COUNT(p) FROM Product p", Long.class)
	             .getSingleResult();
	}
    
	//상품 등록
	@Override
	public Product save(Product product) {
	    if (product.getProNum() == 0) { // 새로운 상품인 경우
	        em.persist(product); // 상품 정보 저장
	        return product;
	    } else {
	        return em.merge(product); // 기존 상품 정보 업데이트
	    }
	}

	
	//재고 리스트
	@Override
	public List<ProductDTO> stockList(Map<String, Object> params) {
		List<Product> productList = em.createQuery("SELECT p FROM Product p", Product.class).getResultList();
	    
	    //엔티티 리스트를 DTO 리스트로 변환
		List<ProductDTO> productDTOList = productList.stream()
				//Product 인스턴스를 ProductDTO로 변환
			    .map(ProductDTO::toDTO) 
			    .collect(Collectors.toList());
	    return productDTOList;
	}

	//재고 리스트 건수
	@Override
	public Long stockListCount(Map<String, Object> params) {
		return em.createQuery("SELECT COUNT(p) FROM Product p", Long.class)
	             .getSingleResult();
	}

	//재고 수정


}
