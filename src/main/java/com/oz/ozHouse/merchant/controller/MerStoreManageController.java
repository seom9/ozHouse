package com.oz.ozHouse.merchant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.oz.ozHouse.merchant.service.StoreManageService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MerStoreManageController {

	private final StoreManageService storeManageService;
	
	
	@GetMapping("mainStoreManagement.do")
	public String storeManage(HttpServletRequest req) {
		req.setAttribute("noticeTitleList", storeManageService.getStoreNotice());
		return "merchant/store/storeMain/storeManagementMain";
	}
}
