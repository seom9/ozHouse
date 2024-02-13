package com.oz.ozHouse.merchant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oz.ozHouse.merchant.service.NoticeService;
import com.oz.ozHouse.merchant.service.StoreManageService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/merchant/store")
public class MerStoreManageController {

	private final StoreManageService storeManageService;
	private final NoticeService noticeService;
	
	@GetMapping("/storeHome")
	public String storeManage(HttpServletRequest req) {
//		req.setAttribute("allCount", storeManageService.allCount());
//		req.setAttribute("waitCount", storeManageService.waitCount());
//		req.setAttribute("requestCount", storeManageService.requestCount());
//		req.setAttribute("cancleCount", storeManageService.cancleCount());
//		req.setAttribute("requestCancle", storeManageService.requestCancle());
//		req.setAttribute("saleOk", storeManageService.saleOk());
//		req.setAttribute("readyCount", storeManageService.readyCount());
//		req.setAttribute("deliveryCount", storeManageService.deliveryCount());
//		req.setAttribute("completeCount", storeManageService.completeCount());
//		req.setAttribute("exchangeCount", storeManageService.exchangeCount());
//		req.setAttribute("returnCount", storeManageService.returnCount());
//		req.setAttribute("boardCount", storeManageService.boardCount());
		req.setAttribute("noticeTitleList", noticeService.storeNotice());
		return "merchant/store/storeMain/storeManagementMain";
	}
}
