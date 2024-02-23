package com.oz.ozHouse.client.controller.shopping;

import java.io.IOException;
import java.net.BindException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.modelmapper.internal.Errors;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.oz.ozHouse.client.security.MemberSecurityDTO;
import com.oz.ozHouse.client.service.CartService;
import com.oz.ozHouse.dto.client.member.ClientProductDTO;
import com.oz.ozHouse.dto.client.member.ProQuanDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@Validated
@PreAuthorize("hasAnyRole('ROLE_CLIENT')")
@RequiredArgsConstructor
public class CartController {
	
	private final CartService cartService;
	
	@GetMapping("/cart")
	public String cart() {
		return "client/main/cart";
	}
	
	// Cart : session 저장
	@GetMapping("/cart/{productNum}/{quantity}")
	public String cartAdd (HttpServletRequest req, HttpSession session,
											@SessionAttribute(value = "cart", required = false) List<ProQuanDTO> cart,
											@AuthenticationPrincipal MemberSecurityDTO member,
											@PathVariable("productNum") int productNum,
											@PathVariable("quantity") int quantity)
											throws IOException {
		
		ClientProductDTO dto = cartService.getProduct(productNum);
		
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
				return "redirect:/cart";
			}
		}
		
		ProQuanDTO newCart = ProQuanDTO.builder().productDTO(dto).quantity(quantity).build();
		cart.add(newCart);
		session.setAttribute("cart", cart);
		// session.setAttribute("encodedImages", encodedImages);
		return "redirect:/cart";
	}
	
	
	@GetMapping("/cart/{productNum}/{quantity}/update")
	@ResponseBody
	public String cartUpdate (HttpServletRequest req, HttpSession session,
											@SessionAttribute("cart") List<ProQuanDTO> cart,
											@PathVariable("productNum") int productNum,
											@PathVariable("quantity") int quantity) {
		
		ClientProductDTO dto = cartService.getProduct(productNum);
		
		if (cart == null) cart = new ArrayList<ProQuanDTO>();
		
		for (ProQuanDTO cartDTO : cart) {
			if (cartDTO.getProductDTO().getProNum() == dto.getProNum()) {
				ProQuanDTO plusCart = ProQuanDTO.builder()
											.productDTO(dto)
											.quantity(quantity)
											.build();
				cart.remove(cartDTO);
				if (plusCart.getQuantity() > 0) cart.add(plusCart);
				session.setAttribute("cart", cart);
				return "hi";
			}
		}
		
		return "fail";
	}
	
}
