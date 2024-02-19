package com.oz.ozHouse.merchant.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oz.ozHouse.domain.Merchant;
import com.oz.ozHouse.domain.Product;
import com.oz.ozHouse.dto.ProductDTO;
import com.oz.ozHouse.dto.RequestProductDTO;
import com.oz.ozHouse.merchant.repository.MerProductRepository;
import com.oz.ozHouse.merchant.repository.loginRepository.MerLoginRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // 의존성 주입
public class MerProServiceImpl implements MerProService {

	private final MerProductRepository proRepository;
	private final MerLoginRepository merchantRepository;

	// 상품 등록
	@Override
	@Transactional
	public String insertProduct(ProductDTO dto) {
		Merchant merchant = merchantRepository.findById(dto.getMerNum())
				.orElseThrow(() -> new IllegalArgumentException());
		Product pro = new Product(dto);
		pro.setMerchant(merchant);
		proRepository.save(pro);
		return dto.getProName();
	}

	// 상품 상세보기
	@Override
	public ProductDTO getProduct(Integer proNum) {
        return proRepository.findByProNum(proNum)
                .orElseThrow(() -> new IllegalArgumentException("proNum : " + proNum));
    }

	// 수정 상품 상세보기
//	@Override
//	public RequestProductDTO getreProduct(String proNum) {
//        return proRepository.findRequestByProNum(Integer.parseInt(proNum))
//                .orElse(null); 
//    }

	// 조회 리스트
	@Override
	public List<ProductDTO> listProduct(Map<String, Object> params) {
		return proRepository.listProduct(params);
	}

	// 조회 리스트 건수
	@Override
	public Long listCount(Map<String, Object> params) {
		return proRepository.listCount(params);
	}

	// 요청 리스트
	@Override
	public List<ProductDTO> requestList(Map<String, Object> params) {
		return proRepository.requestList(params);
	}

	// 요청 리스트 건수
	@Override
	public Long requestListCount(Map<String, Object> params) {
		return proRepository.requestListCount(params);
	}

	// 재고 리스트
	@Override
	public List<ProductDTO> stockList(Map<String, Object> params) {
		return proRepository.stockList(params);
	}

	// 재고 리스트 건수
	@Override
	public Long stockListCount(Map<String, Object> params) {
		return proRepository.stockListCount(params);
	}

	// 재고 수정
	@Override
	@Transactional
	public boolean updateProductStock(Map<String, Object> params) {
		Optional<Product> productOptional = proRepository.findById(Integer.parseInt((String) params.get("proNum")));
		if (productOptional.isPresent()) {
			Product product = productOptional.get();
			product.setProQuantity(Integer.parseInt((String) params.get("proQuantity")));
			proRepository.save(product);
			return true;
		} else {
			return false;
		}
	}
}
