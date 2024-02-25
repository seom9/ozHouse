package com.oz.ozHouse.client.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.oz.ozHouse.client.repository.MemberRepository;
import com.oz.ozHouse.client.repository.OrderRepository;
import com.oz.ozHouse.client.repository.ProInformRepository;
import com.oz.ozHouse.client.repository.ProductRepository;
import com.oz.ozHouse.client.repository.UserCouponRepository;
import com.oz.ozHouse.domain.Member;
import com.oz.ozHouse.domain.OrderTb;
import com.oz.ozHouse.domain.ProInform;
import com.oz.ozHouse.domain.UserCoupon;
import com.oz.ozHouse.dto.MerCouponDTO;
import com.oz.ozHouse.dto.client.member.ClientOrderConfirmDTO;
import com.oz.ozHouse.dto.client.member.ClientOrderDTO;
import com.oz.ozHouse.dto.client.member.ClientProductDTO;
import com.oz.ozHouse.dto.client.member.ProQuanDTO;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService{
	
	private final MemberRepository memberRepository;
	private final OrderRepository orderRepository;
	private final ProductRepository productRepository;
	private final UserCouponRepository couponRepository;
	private final ProInformRepository proInformRepository;
	
	@Override
	public OrderTb order(ClientOrderDTO dto, String memberId, List<ProQuanDTO> orderProducts, List<String> selectedCoupons) {

	    // 1. OrderTb 생성 
	    Member member = memberRepository.findByMemberId(memberId);
	    OrderTb order = ClientOrderDTO.createNewOrder(dto, member);
	    
	    // 2. ProInforms, useCoupons 생성
	    List<ProInform> proInfroms = createProInforms(orderProducts, order);
	    List<UserCoupon> userCoupons = null;
	    if (selectedCoupons != null) userCoupons = CreateUserCoupons(selectedCoupons, order);
	    
	    // 3. OrderTb 저장
	    order = orderRepository.save(order);
	    
	    // 4. ProInforms, useCoupons 저장
	    proInfroms.forEach(proInform -> proInformRepository.save(proInform));
	    if (userCoupons != null) userCoupons.forEach(couponRepository::save);
	    
	    return order;
	}

	private List<ProInform> createProInforms(List<ProQuanDTO> orderProducts, OrderTb order) {
		
        List<ProInform> proInforms = orderProducts.stream()
                			.map(orderProduct -> ProInform.builder()
						                        .product(productRepository.findByProNum(orderProduct.getProductDTO().getProNum()))
						                        .quantity(orderProduct.getQuantity())
						                        .orderTb(order)
						                        .build())
                			.collect(Collectors.toList());
		
		return proInforms;
	}
	
	private List<UserCoupon> CreateUserCoupons(List<String> useCoupons, OrderTb order) {
	    List<UserCoupon> useUserCoupons = useCoupons.stream()
										            .map(couponCode -> Integer.parseInt(couponCode))
										            .map(intCouponCode -> {
										                UserCoupon userCoupon = couponRepository.findByMerCoupon_MerCouponnum(intCouponCode);
										                userCoupon.setOrder(order); 
										                return userCoupon;
										            })
										            .collect(Collectors.toList());

	    return useUserCoupons;
	}

	@Override
	public OrderTb getOrder(long oNum) {
		Optional<OrderTb> result = orderRepository.findOrderWithItemsAndCouponsByoNum(oNum);
		result.get();
		return result.get();
	}

	@Override
	public List<ProQuanDTO> getProQuanDTO(List<ProInform> proInforms) {
		List<ProQuanDTO> proQuanDTOs = proInforms.stream()
			    .map(proInform -> ProQuanDTO.builder()
			        .productDTO(ClientProductDTO.from(proInform.getProduct()))
			        .quantity(proInform.getQuantity())
			        .build())
			    .collect(Collectors.toList());
		return proQuanDTOs;
	}

	@Override
	public List<MerCouponDTO> getMerCouponDTO(List<UserCoupon> useCoupons) {
		List<MerCouponDTO> useMerCoupons = useCoupons.stream()
				.map(useCoupon -> MerCouponDTO.from(useCoupon.getMerCoupon()))
				.collect(Collectors.toList());
		return useMerCoupons;
	}

	
}
