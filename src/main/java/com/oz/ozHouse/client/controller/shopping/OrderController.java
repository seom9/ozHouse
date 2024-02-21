package com.oz.ozHouse.client.controller.shopping;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oz.ozHouse.client.service.OrderService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@Validated
@RequiredArgsConstructor
public class OrderController {
	
	private final OrderService orderService;

	@PostMapping("/order/{memberId}/{mode}")
	public String order_main(HttpServletRequest req,  HttpSession session,
									@RequestParam(required = false) String mode) {

		
		// userCoupon
		// orderProduct
		// point
		
		switch(mode) {
			case "cart" :
				Li
			case "one" :
			case "plus" :
		}

		if (mode.equals("all")) {
			HashMap<ProductDTO, Integer> orderProducts = (HashMap) session.getAttribute("cart");
			if (orderProducts == null)
				orderProducts = new HashMap<ProductDTO, Integer>();
			for (ProductDTO pdto : orderProducts.keySet()) {
				if (pdto.getProduct_num() == dto.getProduct_num()) {
					orderProducts.put(pdto, orderProducts.get(pdto) + order_count1);
					List<Mer_CouponDTO> can_user_list = can_user_list(memberDTO, orderProducts);
					req.setAttribute("userCouponList", can_user_list);
					req.setAttribute("orderProducts", orderProducts);
					session.setAttribute("orderProducts", orderProducts);
					return "client/main/Order";
				}
			}
			orderProducts.put(dto, order_count1);
			List<Mer_CouponDTO> can_user_list = can_user_list(memberDTO, orderProducts);
			req.setAttribute("userCouponList", can_user_list);
			req.setAttribute("orderProducts", orderProducts);
			session.setAttribute("orderProducts", orderProducts);
			return "client/main/Order";
		} else {
			HashMap<ProductDTO, Integer> orderProducts = new HashMap<ProductDTO, Integer>();
			orderProducts.put(dto, order_count1);
			List<Mer_CouponDTO> can_user_list = can_user_list(memberDTO, orderProducts);
			req.setAttribute("userCouponList", can_user_list);
			req.setAttribute("orderProducts", orderProducts);
			session.setAttribute("orderProducts", orderProducts);
			return "client/main/Order";
		}
	}

}
