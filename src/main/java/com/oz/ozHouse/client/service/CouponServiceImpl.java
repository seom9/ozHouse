package com.oz.ozHouse.client.service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.oz.ozHouse.client.repository.ClientMerCouponRepository;
import com.oz.ozHouse.client.repository.MemberRepository;
import com.oz.ozHouse.client.repository.UserCouponRepository;
import com.oz.ozHouse.domain.Member;
import com.oz.ozHouse.domain.MerCoupon;
import com.oz.ozHouse.domain.UserCoupon;
import com.oz.ozHouse.dto.MerCouponDTO;
import com.oz.ozHouse.dto.client.member.ProQuanDTO;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional // 해당 객체를 감싸는 별도의 클래스를 생성
public class CouponServiceImpl implements CouponService{
	
	private final ClientMerCouponRepository clientMerCouponRepository; 
	private final MemberRepository memberRepository;
	private final UserCouponRepository userCouponRepository;


	@Override
	public List<MerCouponDTO> getAllCoupons() {
		List<MerCoupon> merCoupons = clientMerCouponRepository.findAll();

		if (merCoupons == null) return null;
		
		List<MerCouponDTO> merCouponDTOs = merCoupons.stream()
							                .map(data -> MerCouponDTO.from(data))
							                .collect(Collectors.toList());
		
		return merCouponDTOs;
	}


	@Override
	public List<MerCouponDTO> getUserCoupons(String memberId) {
		
		Optional<Member> result = memberRepository.findMemberWithCouponsByMemberId(memberId);
		if (result.isEmpty()) return null;
		Member member = result.get();
		
		List<MerCouponDTO> merCouponDTOs = member.getCoupons().stream()
				.filter(userCoupon -> !userCoupon.isUserCouponActive())
		        .map(userCoupon -> MerCouponDTO.from(userCoupon.getMerCoupon()))
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


	@Override
	public HashSet<MerCouponDTO> getOrderCoupons(String memberId, List<ProQuanDTO> products) {
		Member member = memberRepository.findByMemberId(memberId);
		TreeSet<Integer> merNums = new TreeSet<>();
		
		// 상품에 포함된 판매자 번호 저장
		for (ProQuanDTO dto : products) {
			merNums.add(dto.getProductDTO().getMerNum());
		}
		
		// 판매자 번호가 있다면 treeSet에 해당 userCoupon 추가
		HashSet<MerCouponDTO> merCouponDTOs = member.getCoupons().stream()
				.filter(userCoupon -> !userCoupon.isUserCouponActive())
		        .map(userCoupon -> MerCouponDTO.from(userCoupon.getMerCoupon()))
		        .filter(merCouponDTO -> merNums.contains(merCouponDTO.getMerNum()))
		        .collect(Collectors.toCollection(HashSet::new));
		
		return merCouponDTOs;
	}
	
	
}
