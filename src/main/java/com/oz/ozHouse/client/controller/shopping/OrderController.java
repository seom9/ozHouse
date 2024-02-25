package com.oz.ozHouse.client.controller.shopping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import com.oz.ozHouse.dto.MemberDTO;
import com.oz.ozHouse.dto.MerCouponDTO;
import com.oz.ozHouse.dto.client.member.ClientOrderDTO;
import com.oz.ozHouse.dto.client.member.ClientProductDTO;
import com.oz.ozHouse.dto.client.member.ProQuanDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@Validated
@RequiredArgsConstructor
public class OrderController {
	
	//private final OrderService orderService;
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
									@RequestParam(required = false) List<String> selectedCoupons,
									@ModelAttribute ClientOrderDTO orderInfo) {
		
		// 1. oderProducts 의 List<proQuanDTO> 를 가져와서 하나하나 ProInformDTO 으로 변환
		LocalDateTime localDateTime = LocalDateTime.now();
		String localDateTimeFormat1 = Integer.toString(member.getMemberNum()) + localDateTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
		
		
		
		// 2. 사용한 쿠폰 가져와서 userCoupon 과 대조, orderNum 입혀 줌 / 저장해 줌
		
		
		// 3. memberPoint 가져와서 memberUpdate 수행해 줌
		
		
		return "client/main/order_confirm";
	}
	
//	   @RequestMapping(value = "/order_success.do", method = RequestMethod.POST)
//	   public String order_success(HttpServletRequest req, OrderDTO dto,
//	         @RequestParam(required = false) List<String> selectedCoupons) {
//	      HttpSession session = req.getSession();
//	      LocalDateTime localDateTime = LocalDateTime.now();
//	      String memberNum = Integer.toString(getMemberNum(req));
//
//	      String localDateTimeFormat1 = memberNum + localDateTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
//
//	      long order_code = Long.parseLong(localDateTimeFormat1);
//	      System.out.println(order_code);
//	      MemberDTO member = getMember(req);
//
//	      String member_id = member.getMember_id();
//
//	      String ad1 = req.getParameter("sample6_address");
//	      String ad2 = req.getParameter("sample6_detailAddress");
//	      String ad3 = req.getParameter("sample6_extraAddress");
//	      System.out.println(ad1 + "/" + ad2 + "/" + ad3);
//
//	      int user_point = member.getMember_point();
//	      int final_discount_point = Integer.parseInt(req.getParameter("final_discount_point"));
//	      int final_discount_coupon = Integer.parseInt(req.getParameter("final_discount_coupon"));
//	      int member_use_service = final_discount_point + final_discount_coupon;
//
//	      HashMap<ProductDTO, Integer> orderProducts = (HashMap) session.getAttribute("orderProducts");
//	      int i = 0;
//	      for (ProductDTO pdto : orderProducts.keySet()) {
//	         dto.setMember_id(member_id);
//	         dto.setOrder_name(req.getParameter("member_name"));
//	         dto.setOrder_hp1(req.getParameter("member_hp1"));
//	         dto.setOrder_hp2(req.getParameter("member_hp2"));
//	         dto.setOrder_hp3(req.getParameter("member_hp3"));
//	         dto.setOrder_code(order_code);
//	         dto.setProduct_num(pdto.getProduct_num());
//	         dto.setOrder_orderlike("ok");
//	         dto.setOrder_refund("f");
//
//	         // 만약 쿠폰과 포인트를 사용하지 않았다면?
//	         if (member_use_service == 0) {
//	            user_point += pdto.getProduct_point() * orderProducts.get(pdto);
//	            System.out.println(user_point);
//	         }
//
//	         // 쿠폰과 포인트를 사용했을 시 첫 번째 행에만 쿠폰과 포인트 저장 / 멤버 포인트 업데이트
//	         if (i == 0) {
//	            dto.setOrder_dis_point(final_discount_point);
//	            user_point -= final_discount_point;
//	            dto.setOrder_dis_coupon(final_discount_coupon);
//	         }
//	         dto.setOrder_postcode(req.getParameter("member_postcode1"));
//	         dto.setOrder_place(ad1 + "/" + ad2 + "/" + ad3);
//	         dto.setOrder_count(orderProducts.get(pdto));
//	         dto.setOrder_assembly_cost(pdto.getProduct_assembly_cost() * orderProducts.get(pdto));
//	         dto.setOrder_price(pdto.getProduct_price());
//
//	         int res = shoppingMapper.insertOrder(dto);
//
//	         pdto.setProduct_quantity(pdto.getProduct_quantity() - orderProducts.get(pdto));
//	         pdto.setProduct_purchases_count(pdto.getProduct_purchases_count() + orderProducts.get(pdto));
//	         int res2 = shoppingMapper.updateOrderProduct(pdto);
//
//	         System.out.println(res);
//	         System.out.println(res2);
//	         i++;
//	      }
//
//	      // 쿠폰한 사용 처리
//	      if (selectedCoupons != null) {
//	         for (String coupon : selectedCoupons) {
//	            User_CouponDTO ucdto = new User_CouponDTO();
//	            ucdto.setMember_num(member.getMember_num());
//	            ucdto.setMer_coupon_num(Integer.parseInt(coupon));
//	            ucdto.setOrder_code(order_code);
//	            int res = shoppingMapper.selectedCoupons(ucdto);
//	            System.out.println("쿠폰 처리 : " + res);
//	         }
//	      }
//
//	      // 포인트 처리
//	      member.setMember_point(user_point);
//	      int res1 = shoppingMapper.updateMemberPoint(member);
//	      System.out.println("포인트 처리 : " + res1);
//
//	      // 첫 번째 확인이므로 mode=first
//	      return "redirect:order_confirm.do?mode=first&order=" + order_code;
//	   }

}
