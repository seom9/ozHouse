package com.oz.ozHouse.client.controller.shopping;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.oz.ozHouse.client.security.MemberSecurityDTO;
import com.oz.ozHouse.client.service.CartService;
import com.oz.ozHouse.client.service.CouponService;
import com.oz.ozHouse.client.service.MemberService;
import com.oz.ozHouse.client.service.OrderService;
import com.oz.ozHouse.domain.OrderTb;
import com.oz.ozHouse.dto.MemberDTO;
import com.oz.ozHouse.dto.MerCouponDTO;
import com.oz.ozHouse.dto.client.member.ClientOrderConfirmDTO;
import com.oz.ozHouse.dto.client.member.ClientOrderDTO;
import com.oz.ozHouse.dto.client.member.ClientOrderListDTO;
import com.oz.ozHouse.dto.client.member.ClientProductDTO;
import com.oz.ozHouse.dto.client.member.ProQuanDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@Validated
@RequiredArgsConstructor
public class OrderController {
	
	private final OrderService orderService;
	private final CartService cartService;
	private final MemberService memberService;
	private final CouponService couponService;
	
	  
	/*
	 *  주문하기
	*/
	@PreAuthorize("hasAnyRole('ROLE_CLIENT')")
	@GetMapping(value = {"/order/{mode}", "/order/{mode}/{proNum}/{quantity}"})
	public String order_main(HttpServletRequest req, HttpSession session,
									@SessionAttribute("cart") List<ProQuanDTO> cart,
									@AuthenticationPrincipal MemberSecurityDTO member,
									@PathVariable("mode") String mode,
									@PathVariable(value="proNum", required = false) Integer proNum,
									@PathVariable(value="quantity", required = false) Integer quantity) {

		List<ProQuanDTO> orderProducts = new ArrayList<ProQuanDTO>();
		MemberDTO memDTO = memberService.getMember(member.getUsername());
		
		// all, one 일 경우 해당 상품 담을 객체 선언
		ClientProductDTO dto;
		ProQuanDTO plusOrder;
		
		switch(mode) {
			case "cart" :
				orderProducts = cart;
				break;
			case "one" :
				dto = cartService.getProduct(proNum);
				plusOrder = ProQuanDTO.builder()
										.productDTO(dto)
										.quantity(quantity)
										.build();
				orderProducts.add(plusOrder);
				break;
			case "all" :
				orderProducts = cart;
				// if (orderProducts == null) orderProducts = new ArrayList<ProQuanDTO>();
				dto = cartService.getProduct(proNum);
				plusOrder = ProQuanDTO.builder()
										.productDTO(dto)
										.quantity(quantity)
										.build();
				orderProducts.add(plusOrder);
				break;
		}
		
		// 주문 상품 중 사용할 수 있는 쿠폰 뽑기
		HashSet<MerCouponDTO> merCoupons = couponService.getOrderCoupons(member.getUsername(), orderProducts);
		
		session.setAttribute("orderProducts", orderProducts);
		req.setAttribute("coupons", merCoupons);
		req.setAttribute("member", memDTO);
		
		return "client/main/Order";

	}

	
	/*
	 * 주문 성공
	 */
	@PreAuthorize("hasAnyRole('ROLE_CLIENT')")
	@PostMapping("/order/success")
	public String order(HttpServletRequest req, HttpSession session,
									@SessionAttribute("orderProducts") List<ProQuanDTO> orderProducts,
									@AuthenticationPrincipal MemberSecurityDTO member,
									@RequestParam(required = false, name = "selectedCoupons") List<String> selectedCoupons,
									@Validated @ModelAttribute ClientOrderDTO orderInfo) {
				
		// 1. DB 저장
		// 1-1 OrderTb 생성
		OrderTb order = orderService.order(orderInfo, member.getUsername(), orderProducts, selectedCoupons);
		// 1-2 memberPoint 업데이트
		memberService.updatePoint(member.getUsername(), orderInfo.getODisPoint());
		
		return "redirect:/order/"+order.getONum()+"/confirm";
	}
	
	@PreAuthorize("hasAnyRole('ROLE_CLIENT')")
	@GetMapping("/order/{oNum}/confirm")
	public String confirmOrder(HttpServletRequest req, @PathVariable("oNum") long oNum) {
		
		OrderTb order = orderService.getOrder(oNum);
		
		req.setAttribute("orderinfo", ClientOrderConfirmDTO.fromEntity(orderService.getOrder(oNum)));		
		req.setAttribute("confirmOrderProducts", orderService.getProQuanDTO(order.getOrderItems()));
		req.setAttribute("userCouponList", orderService.getMerCouponDTO(order.getUseCoupons()));
		
		return "client/main/order_confirm";
	}
	
	@PreAuthorize("hasAnyRole('ROLE_CLIENT')")
	@GetMapping("/mypage/shopping")
	public String mypageShopping(HttpServletRequest req,
									@AuthenticationPrincipal MemberSecurityDTO member) {
		
		List<ClientOrderListDTO> orders = orderService.getMemberWithOrder(member.getUsername());
		
		req.setAttribute("orders", orders);
		return "client/mypage/mypage_shopping";
	}

	@PreAuthorize("hasAnyRole('ROLE_CLIENT')")
	@GetMapping("/order/cancel/{oNum}")
	public String orderCancel(HttpServletRequest req, @PathVariable("oNum") long oNum,
									@AuthenticationPrincipal MemberSecurityDTO member) {
		
		orderService.cancelOrder(member.getMemberNum(), oNum);
		 
		return  "redirect:/order/"+oNum+"/confirm";
	}
	
}
