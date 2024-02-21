package com.oz.ozHouse.client.controller.shopping;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@Validated
@RequiredArgsConstructor
public class ShoppingController {
	

	
	/*





	   @RequestMapping(value = "/order_success.do", method = RequestMethod.POST)
	   public String order_success(HttpServletRequest req, OrderDTO dto,
	         @RequestParam(required = false) List<String> selectedCoupons) {
	      HttpSession session = req.getSession();
	      LocalDateTime localDateTime = LocalDateTime.now();
	      String memberNum = Integer.toString(getMemberNum(req));

	      String localDateTimeFormat1 = memberNum + localDateTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));

	      long order_code = Long.parseLong(localDateTimeFormat1);
	      System.out.println(order_code);
	      MemberDTO member = getMember(req);

	      String member_id = member.getMember_id();

	      String ad1 = req.getParameter("sample6_address");
	      String ad2 = req.getParameter("sample6_detailAddress");
	      String ad3 = req.getParameter("sample6_extraAddress");
	      System.out.println(ad1 + "/" + ad2 + "/" + ad3);

	      int user_point = member.getMember_point();
	      int final_discount_point = Integer.parseInt(req.getParameter("final_discount_point"));
	      int final_discount_coupon = Integer.parseInt(req.getParameter("final_discount_coupon"));
	      int member_use_service = final_discount_point + final_discount_coupon;

	      HashMap<ProductDTO, Integer> orderProducts = (HashMap) session.getAttribute("orderProducts");
	      int i = 0;
	      for (ProductDTO pdto : orderProducts.keySet()) {
	         dto.setMember_id(member_id);
	         dto.setOrder_name(req.getParameter("member_name"));
	         dto.setOrder_hp1(req.getParameter("member_hp1"));
	         dto.setOrder_hp2(req.getParameter("member_hp2"));
	         dto.setOrder_hp3(req.getParameter("member_hp3"));
	         dto.setOrder_code(order_code);
	         dto.setProduct_num(pdto.getProduct_num());
	         dto.setOrder_orderlike("ok");
	         dto.setOrder_refund("f");

	         // 만약 쿠폰과 포인트를 사용하지 않았다면?
	         if (member_use_service == 0) {
	            user_point += pdto.getProduct_point() * orderProducts.get(pdto);
	            System.out.println(user_point);
	         }

	         // 쿠폰과 포인트를 사용했을 시 첫 번째 행에만 쿠폰과 포인트 저장 / 멤버 포인트 업데이트
	         if (i == 0) {
	            dto.setOrder_dis_point(final_discount_point);
	            user_point -= final_discount_point;
	            dto.setOrder_dis_coupon(final_discount_coupon);
	         }
	         dto.setOrder_postcode(req.getParameter("member_postcode1"));
	         dto.setOrder_place(ad1 + "/" + ad2 + "/" + ad3);
	         dto.setOrder_count(orderProducts.get(pdto));
	         dto.setOrder_assembly_cost(pdto.getProduct_assembly_cost() * orderProducts.get(pdto));
	         dto.setOrder_price(pdto.getProduct_price());

	         int res = shoppingMapper.insertOrder(dto);

	         pdto.setProduct_quantity(pdto.getProduct_quantity() - orderProducts.get(pdto));
	         pdto.setProduct_purchases_count(pdto.getProduct_purchases_count() + orderProducts.get(pdto));
	         int res2 = shoppingMapper.updateOrderProduct(pdto);

	         System.out.println(res);
	         System.out.println(res2);
	         i++;
	      }

	      // 쿠폰한 사용 처리
	      if (selectedCoupons != null) {
	         for (String coupon : selectedCoupons) {
	            User_CouponDTO ucdto = new User_CouponDTO();
	            ucdto.setMember_num(member.getMember_num());
	            ucdto.setMer_coupon_num(Integer.parseInt(coupon));
	            ucdto.setOrder_code(order_code);
	            int res = shoppingMapper.selectedCoupons(ucdto);
	            System.out.println("쿠폰 처리 : " + res);
	         }
	      }

	      // 포인트 처리
	      member.setMember_point(user_point);
	      int res1 = shoppingMapper.updateMemberPoint(member);
	      System.out.println("포인트 처리 : " + res1);

	      // 첫 번째 확인이므로 mode=first
	      return "redirect:order_confirm.do?mode=first&order=" + order_code;
	   }

	@RequestMapping(value = "/order_confirm.do", method = RequestMethod.GET)
	public String order_confirm(HttpServletRequest req) {
		long order_code = Long.parseLong(req.getParameter("order"));
		List<OrderDTO> confirmOrderProducts = shoppingMapper.getOrder(order_code);
		HashMap<ProductDTO, Integer> orderhm = new HashMap<>();
		List<Mer_CouponDTO> selectOrderCoupon = shoppingMapper.selectOrderCoupon(order_code);

		for (OrderDTO dto : confirmOrderProducts) {
			orderhm.put(shoppingMapper.getProduct(dto.getProduct_num()), dto.getOrder_count());
		}

		req.setAttribute("userCouponList", selectOrderCoupon);
		req.setAttribute("member", getMember(req));
		req.setAttribute("orderinfo", confirmOrderProducts.get(0));
		System.out.println("뭐임?" + confirmOrderProducts.get(0).getOrder_dis_point());
		req.setAttribute("confirmOrderProducts", orderhm);

		return "client/main/order_confirm";
	}

	   @RequestMapping(value = "/order_cancel.do", method = RequestMethod.GET)
	   public String order_cancel(HttpServletRequest req) {
	      long order_code = Long.parseLong(req.getParameter("order"));
	      List<OrderDTO> confirmOrderProducts = shoppingMapper.getOrder(order_code);
	      MemberDTO member = getMember(req);
	      int user_point = member.getMember_point();

	      for (OrderDTO dto : confirmOrderProducts) {
	         // 포인트 되돌려주기
	         dto.setOrder_orderlike("return");
	         if (dto.getOrder_dis_point() >= 1) {
	            user_point += dto.getOrder_dis_point();
	         }

	         // 주문 수량 되돌리기
	         ProductDTO pdto = shoppingMapper.getProduct(dto.getProduct_num());
	         pdto.setProduct_quantity(pdto.getProduct_quantity() + dto.getOrder_count());
	         int res = shoppingMapper.setProductQuantity(pdto);
	      }

	      member.setMember_point(user_point);
	      int res = shoppingMapper.updateMemberPoint(member);
	      int res1 = shoppingMapper.orderCancel(order_code);
	      System.out.println(res);

	      req.setAttribute("msg", "주문 취소 완료");
	      req.setAttribute("url", "mypage_shopping.do");

	      return "message";
	   }
	*/
	
}