package com.oz.ozHouse.client.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.oz.ozHouse.client.repository.MemberRepository;
import com.oz.ozHouse.client.repository.ProductRepository;
import com.oz.ozHouse.client.repository.ScrapRepository;
import com.oz.ozHouse.domain.Member;
import com.oz.ozHouse.domain.Product;
import com.oz.ozHouse.domain.Scrap;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional // 해당 객체를 감싸는 별도의 클래스를 생성
public class ScrapService {
	
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
			Scrap scrap = Scrap.builder()
					.member(member)
					.product(product)
					.build();
	
			scrapRepository.save(scrap);
			return true;
		}else {
			Scrap scrap = Scrap.builder()
					.member(member)
					.product(product)
					.build();
	
			scrapRepository.delete(scrap);
			return false;
		}
		
	}

}
