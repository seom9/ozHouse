package com.oz.ozHouse.client.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.oz.ozHouse.client.repository.MemberRepository;
import com.oz.ozHouse.client.repository.ProductRepository;
import com.oz.ozHouse.client.repository.ScrapRepository;
import com.oz.ozHouse.domain.Member;
import com.oz.ozHouse.domain.Product;
import com.oz.ozHouse.domain.Scrap;
import com.oz.ozHouse.dto.MerCouponDTO;
import com.oz.ozHouse.dto.ProductDTO;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional // 해당 객체를 감싸는 별도의 클래스를 생성
public class ScrapService {
	
	// 가현
	// 스크랩 기능 별로 없음 & 가현만 써서 implements 생성하지 않았습니다
	
	private final ModelMapper modelMapper;
	private final ScrapRepository scrapRepository;
	private final MemberRepository memberRepository;
	private final ProductRepository productRepository;
	
	public boolean doScrap(String memberId, int productNum, boolean isScrap) {
		
		Member member = memberRepository.findByMemberId(memberId);
		Optional<Product> result = productRepository.findById(productNum);
		if (result.isEmpty()) return false;
		Product product = result.get();
		
		// 존재인지 아닌지는 프론트에서 가져오기
		// boolean isExist = scrapRepository.existsByMemberAndProduct(member, product);
		
		// 스크랩인지 아닌지
		if (isScrap) {
			Scrap scrap = Scrap.builder().member(member).product(product).build();
	
			scrapRepository.save(scrap);
			return true;
		}else {
			Scrap scrap = Scrap.builder().member(member).product(product).build();
	
			scrapRepository.delete(scrap);
			return false;
		}
		
	}
	
	// member 가 스크랩한 상품들
	public List<ProductDTO> myScraps(String memberId){
		
		List<Scrap> scraps = scrapRepository.findByMember_MemberId(memberId);
		
		List<ProductDTO> productDTOs = scraps.stream()
		        					    .map(data -> {
		        					        ProductDTO productDTO = modelMapper.map(data.getProduct(), ProductDTO.class);
		        					        productDTO.setProImg(data.getProduct().getImg().getProImg());
		        					        productDTO.setProImgPro(data.getProduct().getImg().getProImgPro());
		        					        productDTO.setProPrice(data.getProduct().getMerPrice().getProPrice());
		        					        productDTO.setProPoint(data.getProduct().getMerPrice().getProPoint());
		        					        productDTO.setProAssemblyCost(data.getProduct().getMerPrice().getProAssemblyCost());
		        					        productDTO.setProDiscountRate(data.getProduct().getMerPrice().getProDiscountRate());
		        					        productDTO.setProDiscountPrice(data.getProduct().getMerPrice().getProDiscountPrice());
		        					        if (memberId != null) {
		        					            productDTO.setScrap(true);
		        					        }
		        					        return productDTO;
		        					        
		        					    })
		        					    .collect(Collectors.toList());


		return productDTOs;
	}
	
	// 해당 상품 스크랩 boolean
	public boolean isScrap(String memberId, int proNum) {
		return scrapRepository. existsByMember_MemberIdAndProduct_ProNum(memberId, proNum);
	}

}
