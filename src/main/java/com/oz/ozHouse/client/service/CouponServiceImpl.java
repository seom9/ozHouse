package com.oz.ozHouse.client.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.oz.ozHouse.client.repository.ClientMerCouponRepository;
import com.oz.ozHouse.client.repository.MemberRepository;
import com.oz.ozHouse.client.repository.UserCouponRepository;
import com.oz.ozHouse.domain.Member;
import com.oz.ozHouse.domain.MerCoupon;
import com.oz.ozHouse.domain.UserCoupon;
import com.oz.ozHouse.dto.MerCouponDTO;
import com.oz.ozHouse.dto.UserCouponDTO;

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
	private final UserCouponRepository userCouponRepository;


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
		
		List<MerCouponDTO> merCouponDTOs = member.getCoupons().stream()
									        .map(userCoupon -> modelMapper.map(userCoupon.getMerCoupon(), MerCouponDTO.class))
									        .collect(Collectors.toList());
		
		return merCouponDTOs;
	}


	@Transactional
	@Override
	public boolean addCoupon(String memberId, int merCouponnum) {
	    // 보유한 쿠폰인지 확인
	    List<UserCoupon> existingCoupons = userCouponRepository.findByMember_MemberId(memberId);
	    boolean isCouponExist = existingCoupons.stream()
	            .anyMatch(coupon -> coupon.getMerCoupon().getMerCouponnum() == merCouponnum);
	    if (isCouponExist) return false;

	    // 새 쿠폰 저장
        Member member = memberRepository.findByMemberId(memberId);
        MerCoupon coupon = clientMerCouponRepository.findByMerCouponnum(merCouponnum);
        
        UserCoupon userCoupon = UserCoupon.builder()
						        			.member(member)
						        			.merCoupon(coupon)
						        			.build();
        
        userCouponRepository.save(userCoupon);        
        return true;
	}
	
}
