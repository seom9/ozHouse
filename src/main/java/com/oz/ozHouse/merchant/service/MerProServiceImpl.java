package com.oz.ozHouse.merchant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oz.ozHouse.domain.Merchant;
import com.oz.ozHouse.domain.Product;
import com.oz.ozHouse.dto.ProductDTO;
import com.oz.ozHouse.merchant.repository.MerProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // 의존성 주입
public class MerProServiceImpl implements MerProService {

	private final MerProductRepository proRepository;

//	private final MerchantJoinRepository merRepository;

	//상품 등록
	@Override
	@Transactional
	public String insertProduct(ProductDTO dto) {
		Product pro = new Product(dto);
		System.out.println("service : " + dto.getProName());
		System.out.println("상품명 : " + pro.getProName());
		proRepository.save(pro);
		return dto.getProName();
	}

	//재고 리스트
	@Override
	public List<ProductDTO> stockList() {
		return proRepository.stockList();
	}

	//재고 리스트 건수
	@Override
	public Long stockListCount() {
		return proRepository.stockListCount();
	}
	
	@Transactional
    public void updateProductStock(Integer proNum, Integer newQuantity) {
        Product product = proRepository.findByProNum(proNum)
            .orElseThrow(() -> new IllegalArgumentException("상품을 찾을 수 없습니다. 상품번호: " + proNum));
        product.setProQuantity(newQuantity); // 여기서는 상품의 수량을 설정하는 메소드가 있다고 가정합니다.
    }

}
