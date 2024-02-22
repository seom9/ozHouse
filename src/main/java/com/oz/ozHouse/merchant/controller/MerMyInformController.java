package com.oz.ozHouse.merchant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oz.ozHouse.dto.MerchantDTO;
import com.oz.ozHouse.merchant.exception.NotFoundMerNumException;
import com.oz.ozHouse.merchant.service.MerMyInformService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/merchant/home/myinfo")
@RequiredArgsConstructor
public class MerMyInformController {
	private final MerMyInformService myService;

	@GetMapping("/{merNum}")
	public String myInform_view(HttpServletRequest req, @PathVariable("merNum") int merNum) {
		HttpSession session = req.getSession();
		try {
			MerchantDTO dto = myService.myInformView(merNum);
			session.setAttribute("merchantUpdate", dto);
		} catch (NotFoundMerNumException e) {

		}
		return "merchant/main/myInform_view";
	}

}
