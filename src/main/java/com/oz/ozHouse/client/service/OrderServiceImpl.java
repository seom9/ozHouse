package com.oz.ozHouse.client.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import com.oz.ozHouse.client.repository.ClientMerCouponRepository;
import com.oz.ozHouse.client.repository.MemberRepository;
import com.oz.ozHouse.client.repository.OrderRepository;
import com.oz.ozHouse.client.repository.ProInformRepository;
import com.oz.ozHouse.client.repository.ProductRepository;
import com.oz.ozHouse.client.repository.UserCouponRepository;
import com.oz.ozHouse.domain.Member;
import com.oz.ozHouse.domain.MerCoupon;
import com.oz.ozHouse.domain.OrderTb;
import com.oz.ozHouse.domain.ProInform;
import com.oz.ozHouse.domain.UserCoupon;
import com.oz.ozHouse.dto.MerCouponDTO;
import com.oz.ozHouse.dto.client.member.ClientOrderDTO;
import com.oz.ozHouse.dto.client.member.ClientOrderListDTO;
import com.oz.ozHouse.dto.client.member.ClientProductDTO;
import com.oz.ozHouse.dto.client.member.MypagePointDTO;
import com.oz.ozHouse.dto.client.member.ProQuanDTO;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
	
	private final MemberRepository memberRepository;
	private final OrderRepository orderRepository;
	private final ProductRepository productRepository;
	private final UserCouponRepository couponRepository;
	private final ClientMerCouponRepository merCouponRepository; 
	private final ProInformRepository proInformRepository;
	
	@Override
	@Transactional
	public OrderTb order(ClientOrderDTO dto, String memberId, List<ProQuanDTO> orderProducts, List<String> selectedCoupons) {

	    // 1. OrderTb 생성 
	    Member member = memberRepository.findByMemberId(memberId);
	    OrderTb order = ClientOrderDTO.createNewOrder(dto, member);
	    
	    // 2. ProInforms, useCoupons 생성
	    List<ProInform> proInfroms = createProInforms(orderProducts, order);
	    List<UserCoupon> userCoupons = null;
	    if (selectedCoupons != null) userCoupons = CreateUserCoupons(selectedCoupons, order, member);
	    
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
						                        .realPrice(orderProduct.getQuantity() * (orderProduct.getProductDTO().getProPrice() - orderProduct.getProductDTO().getProDiscountPrice()))
						                        .build())
                			.collect(Collectors.toList());
		
		return proInforms;
	}
	 
	
	private List<UserCoupon> CreateUserCoupons(List<String> useCoupons, OrderTb order, Member member) {
	    List<UserCoupon> useUserCoupons = useCoupons.stream()
				            .map(couponCode -> Integer.parseInt(couponCode))
				            .map(intCouponCode -> {
				            	MerCoupon merCoupon = merCouponRepository.getById(intCouponCode);
				                UserCoupon userCoupon = couponRepository.findByMerCouponAndMember(merCoupon, member);
				                userCoupon.setOrder(order); 
				                userCoupon.setUserCouponActive(true);
				                return userCoupon;
				            })
				            .collect(Collectors.toList());

	    return useUserCoupons;
	}
	
	@Override
	@Transactional
	public OrderTb getOrder(long oNum) {
		return orderRepository.findByoNum(oNum);
	}

	@Override
	@Transactional
	public OrderTb getOrderWithCoupons(long oNum) {
		Optional<OrderTb> result = orderRepository.findOrderWithCouponsByoNum(oNum);
		result.get();
		return result.get();
	}
	
	@Override
	@Transactional
	public OrderTb getOrderWithItems(long oNum) {
		Optional<OrderTb> result = orderRepository.findOrderWithItemsByoNum(oNum);
		result.get();
		return result.get();
	}

	@Override
	@Transactional
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
	@Transactional
	public List<MerCouponDTO> getMerCouponDTO(long oNum) {
		Optional<OrderTb> result = orderRepository.findOrderWithCouponsByoNum(oNum);
		OrderTb order = result.get();
		List<MerCouponDTO> useMerCoupons = order.getUseCoupons().stream()
				.map(useCoupon -> MerCouponDTO.from(useCoupon.getMerCoupon()))
				.collect(Collectors.toList());
		return useMerCoupons;
	}


	@Override
	@Transactional
	public List<ClientOrderListDTO> getMemberWithOrder(String memberId) {
	    Optional<Member> result = memberRepository.findMemberWithOrdersByMemberId(memberId);

	    if (result.isPresent()) {
	    	List<ClientOrderListDTO> dto = result.get().getOrderList().stream()
	    	        .map(data -> ClientOrderListDTO.fromEntity(data, getProQuanDTO(data.getOrderItems())))
	    	        .collect(Collectors.toList());
	    	return dto;
	    }
	    return null;
	}


	@Override
	@Transactional
	public void cancelOrder(int memberNum, long oNum) {
    	LocalDateTime localDateTime = LocalDateTime.now();
    	String to = Integer.toString(memberNum).toString() + localDateTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        Long newONum = Long.parseLong(to);
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy/MM/dd");
        String regDate = localDateTime.format(formatter);
        OrderTb newOrderTb = new OrderTb();
        OrderTb orderTb = orderRepository.findByoNum(oNum);
        
        newOrderTb = orderTb;
        newOrderTb.setONum(newONum, "return", regDate);
        
        orderRepository.save(newOrderTb);
	}

	@Override
	@Transactional
	public List<MypagePointDTO> getMypointDTO(String memberId) {
		
		List<ClientOrderListDTO> orders = getMemberWithOrder(memberId);
		
		List<MypagePointDTO> pointDTOs = orders.stream()
						.map(data -> MypagePointDTO.builder()
									.orderCode(data.getOrderNum())
									.orderDate(data.getRegDate())
									.statement((data.getODisPoint() > 0) ? "사용" : (data.getODisPoint() == 0) ? "0" : "적립")
									.point(data.getODisPoint())
									.build())
						.collect(Collectors.toList());
		
		return pointDTOs;
	}
	
	@Override
	@Transactional
	public List<ClientOrderListDTO> getMemberWithOrderTo(String memberId) {
	    Optional<Member> result = memberRepository.findMemberWithOrdersByMemberId(memberId);

	    if (result.isPresent()) {
	    	List<ClientOrderListDTO> dto = result.get().getOrderList().stream()
	    	        .map(data -> ClientOrderListDTO.fromEntity(data, getProQuanDTO(data.getOrderItems())))
	    	        .collect(Collectors.toList());
	    	return dto;
	    }
	    return null;
	}
	
}
