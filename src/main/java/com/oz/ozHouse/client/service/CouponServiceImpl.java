package com.oz.ozHouse.client.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.oz.ozHouse.client.repository.ClientMerCouponRepository;
import com.oz.ozHouse.client.repository.MemberRepository;
import com.oz.ozHouse.domain.Member;
import com.oz.ozHouse.domain.MerCoupon;
import com.oz.ozHouse.dto.MerCouponDTO;

import jakarta.persistence.Entity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional // 해당 객체를 감싸는 별도의 클래스를 생성
public class CouponServiceImpl implements CouponService{
	
	private final ModelMapper modelMapper;
	private final ClientMerCouponRepository clientMerCouponRepository; 
	private final MemberRepository memberRepository;


	@Override
	public List<MerCouponDTO> getAllCoupons() {
		List<MerCoupon> merCoupons = clientMerCouponRepository.findAll();

		if (merCoupons == null) return null;
		
		List<MerCouponDTO> merCouponDTOs = merCoupons.stream()
							                .map(data -> modelMapper.map(data, MerCouponDTO.class))
							                .collect(Collectors.toList());
		
		return merCouponDTOs;
	}


	@Override
	public List<MerCouponDTO> getUserCoupons(String memberId) {
		
		Optional<Member> result = memberRepository.findMemberWithCouponsByMemberId(memberId);
		
		if (result.isEmpty()) return null;
		
		Member member = result.get();
		List<MerCouponDTO> userCouponDTOs = member.getCoupons().stream()
							                .map(data -> modelMapper.map(data, MerCouponDTO.class))
							                .collect(Collectors.toList());
		
		return userCouponDTOs;
	}


	@Transactional
	@Override
	public void addCoupon(String memberId, int merCouponnum) {

        Member member = memberRepository.findByMemberId(memberId);
        
        MerCoupon coupon = clientMerCouponRepository.findByMerCouponnum(merCouponnum);
        
        member.addCoupon(coupon);
        
		System.out.println("==============================================================");
		System.out.println("저장합니다다다아아아아아ㅏ");

        memberRepository.save(member);
		System.out.println("==============================================================");

	}
	
	
	
}
