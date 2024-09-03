package com.oz.ozHouse.merchant.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oz.ozHouse.dto.merchant.ReturnDTO;
import com.oz.ozHouse.merchant.service.MerReturnService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/merchant/{merNum}/store")
@RequiredArgsConstructor
public class MerReturnController {
	private final MerReturnService reService;
	
	@GetMapping("/returns")
	public String returnCancelList(HttpServletRequest req, @PathVariable (value="merNum") int merNum) {
		List<ReturnDTO> list = reService.returnList(merNum);
		int returnCount = list.size();
		req.setAttribute("radio", "all");
		req.setAttribute("search", "all");
		req.setAttribute("orderReturnList", list);
		req.setAttribute("returnCount", returnCount);
		return "merchant/store/returnCancle/returnCancle_returnList";
	}
}
