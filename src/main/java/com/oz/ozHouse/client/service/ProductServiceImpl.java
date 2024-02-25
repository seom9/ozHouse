package com.oz.ozHouse.client.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.oz.ozHouse.client.repository.ProductRepository;
import com.oz.ozHouse.domain.Product;
import com.oz.ozHouse.dto.ProductDTO;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService{
	
	private final ModelMapper modelMapper;
	private final ProductRepository productRepository;
	
	// 상품 전체 리스트
	@Override
	public List<ProductDTO> cliProductList() {
		
		List<Product> productList = productRepository.findAll();
		
		System.out.println("크기" + productList.size());
		
		for(Product dto : productList) {
			System.out.println("가격 : " + dto.getMerPrice().getProPrice());
		}
		
		List<ProductDTO> proList = productList.stream()
									.map(data -> modelMapper.map(data, ProductDTO.class))
									.collect(Collectors.toList());
		
		for(ProductDTO dto2 : proList) {
			System.out.println("가격33 : " + dto2.getProPrice());
		}
		
		return proList;
	}
	
<<<<<<< HEAD
   // 상품 상세보기
   @Override
   public ProductDTO getProduct(Integer proNum) {
       Product product = productRepository.findByProNum(proNum);
       
       return new ProductDTO(product);
   }
=======
	// 상품 상세보기
	@Override
	public ProductDTO getProduct(Integer proNum) {
		
	    Product product = productRepository.findByProNum(proNum);
	    
	    return new ProductDTO(product);
	}
>>>>>>> refs/remotes/main/moon

}
