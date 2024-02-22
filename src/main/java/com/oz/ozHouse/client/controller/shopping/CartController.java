package com.oz.ozHouse.client.controller.shopping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.oz.ozHouse.client.security.MemberSecurityDTO;
import com.oz.ozHouse.client.service.CartService;
import com.oz.ozHouse.dto.ProductDTO;
import com.oz.ozHouse.dto.client.member.ProQuanDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@Validated
@RequiredArgsConstructor
public class CartController {
	
	private final CartService cartService;
	
	@GetMapping("/cart")
	public String cartlist_main() {
		return "client/main/cart";
	}
	
	// Cart : session 저장
	@GetMapping("/cart/{productNum}/{quantity}")
	@ResponseBody
	public String cartAdd (HttpServletRequest req, HttpSession session,
											@SessionAttribute(value = "cart", required = false) List<ProQuanDTO> cart,
											@AuthenticationPrincipal MemberSecurityDTO member,
											@PathVariable("productNum") int productNum,
											@PathVariable("quantity") int quantity)
											throws IOException {
		
		ProductDTO dto = cartService.getProduct(productNum);
		
		if (cart == null) cart = new ArrayList<ProQuanDTO>();
		
		for (ProQuanDTO cartDTO : cart) {
			if (cartDTO.getProductDTO().getProNum() == dto.getProNum()) {
				ProQuanDTO plusCart = ProQuanDTO.builder()
											.productDTO(dto)
											.quantity(cartDTO.getQuantity() + quantity)
											.build();
				cart.remove(cartDTO);
				cart.add(plusCart);
				session.setAttribute("cart", cart);
				return "success";
			}
		}
		
		ProQuanDTO newCart = ProQuanDTO.builder().productDTO(dto).quantity(quantity).build();
		cart.add(newCart);
		session.setAttribute("cart", cart);
		// session.setAttribute("encodedImages", encodedImages);
		return "success";
	}
	
	
	@GetMapping("/cart/{productNum}/{quantity}/del")
	@ResponseBody
	public String cartDel (HttpServletRequest req, HttpSession session,
											@SessionAttribute("cart") List<ProQuanDTO> cart,
											@AuthenticationPrincipal MemberSecurityDTO member,
											@PathVariable("productNum") Integer productNum,
											@PathVariable("quantity") int quantity)
											throws IOException {
		ProductDTO dto = cartService.getProduct(productNum);
		
		if (cart == null) cart = new ArrayList<ProQuanDTO>();
		
		for (ProQuanDTO cartDTO : cart) {
			if (cartDTO.getProductDTO().getProNum() == dto.getProNum()) {
				ProQuanDTO plusCart = ProQuanDTO.builder()
											.productDTO(dto)
											.quantity(cartDTO.getQuantity() - quantity)
											.build();
				cart.remove(cartDTO);
				if (plusCart.getQuantity() > 0) cart.add(plusCart);
				session.setAttribute("cart", cart);
				return "del";
			}
		}
		
		return "none";
	}
	
}
