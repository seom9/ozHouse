package com.oz.ozHouse.merchant.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oz.ozHouse.dto.merchant.DeliveryDTO;
import com.oz.ozHouse.dto.merchant.DeliverySearchDTO;
import com.oz.ozHouse.merchant.service.MerDeliveryService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/merchant/{merNum}/store")
public class MerDeliveryController {
	private final MerDeliveryService deliveryService;
	
	@GetMapping("/orders")
	public String returnCancelList(HttpServletRequest req, 
			@PathVariable("merNum") int merNum,
			@RequestParam(value="mode", required=false) String mode) {
		
		Map<String, String> map = new HashMap<>();
		map.put("mode", mode);
		map.put("merNum", String.valueOf(merNum));
		List<DeliveryDTO> list = null;
		if(mode.equals("all")) {
			list = deliveryService.deliveryList(merNum);
		}else {
			list = deliveryService.deliveryLikeList(map);
		}
		int deliveryCount = list.size();
		req.setAttribute("deliveryCount", deliveryCount);
		req.setAttribute("options", "all");
		req.setAttribute("oLike", "all");
		req.setAttribute("radio", "all");
		req.setAttribute("deliveryList", list);
		req.setAttribute("map", map);
		return "merchant/store/delivery/delivery_list";
	}
	
	@PostMapping("/orders/search")
	public String returnCancelListSearch(HttpServletRequest req, 
			@ModelAttribute DeliverySearchDTO dto) {
		try {
			dto.getStartDate().charAt(0);
			dto.getEndDate().charAt(0);
		}catch(StringIndexOutOfBoundsException e) {
			dto.setStartDate(null);
			dto.setEndDate(null);
		}
		req.setAttribute("map", dto);
		List<DeliveryDTO> list = deliveryService.searchDeliveryList(dto);
		int deliveryCount = list.size();
		req.setAttribute("deliveryCount", deliveryCount);
		req.setAttribute("options", dto.getSearch());
		req.setAttribute("oLike", dto.getOLike());
		req.setAttribute("radio", dto.getORefund());
		req.setAttribute("deliveryList", list);
	
		return "merchant/store/delivery/delivery_list";
	}
}
