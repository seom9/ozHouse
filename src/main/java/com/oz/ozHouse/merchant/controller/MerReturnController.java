package com.oz.ozHouse.merchant.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/merchant/{merNum}/store")
@RequiredArgsConstructor
public class MerReturnController {
	private final MerReturnService reService;
	
	@GetMapping("/returns")
	public String returnCancelList(HttpServletRequest req) {
		List<ListDTO> list = reService.returnCancleList(map);
		int returnCount = reService.countReturn(map);
		req.setAttribute("searchOptions", settinOption("all"));
		req.setAttribute("radioOptions", settinRadio("all"));
		req.setAttribute("orderReturnList", list);
		req.setAttribute("returnCount", returnCount);
		req.setAttribute("map", map);
		return "merchant/store/returnCancle/returnCancle_returnList";
	}
}
