package com.oz.ozHouse.merchant.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oz.ozHouse.dto.merchant.DeliveryDTO;
import com.oz.ozHouse.dto.merchant.ListDTO;
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
		List<DeliveryDTO> list = null;
		Map<String, String> map = new HashMap<>();
		map.put("mode", mode);
		map.put("merNum", String.valueOf(merNum));
		int deliveryCount;
		if(mode.equals("all")) {
			list = deliveryService.deliveryList(merNum);
			deliveryCount = list.size();
		}else {
			list = deliveryService.deliveryLikeList(map);
			deliveryCount = list.size();
		}
		
		req.setAttribute("deliveryCount", deliveryCount);
		req.setAttribute("options", "all");
		req.setAttribute("deliveryList", list);
		req.setAttribute("map", map);
		return "merchant/store/delivery/delivery_list";
	}
}
