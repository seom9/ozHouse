package com.oz.ozHouse.merchant.controller;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oz.ozHouse.merchant.config.MerchantLoginBean;
import com.oz.ozHouse.merchant.service.NoticeService;
import com.oz.ozHouse.merchant.service.StoreManageService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/merchant")
public class MerStoreManageController {

	private final StoreManageService storeManageService;
	private final NoticeService noticeService;
	
	@GetMapping("/message")
    public String showMessage(HttpServletRequest req) {
		req.setAttribute("msg", "로그인 세션 만료. 다시 로그인 해주세요.");
        req.setAttribute("url", "/merchant/login");
		return "message"; 
    }
	
	@GetMapping("/{merNum}/store/storeHome")
    public String storeManage(HttpServletRequest req, @PathVariable(value = "merNum") Integer merNum, @RequestParam Map<String, String> map, RedirectAttributes redirectAttributes) {

		HttpSession session = req.getSession();
		MerchantLoginBean loginOk = (MerchantLoginBean)session.getAttribute("merLoginMember");
		
		if (loginOk == null) {
			String msg = "로그인 후 이용바랍니다.";
			String url = "/merchant/login";
			req.setAttribute("msg", msg);
			req.setAttribute("url", url);
			return "message";
		}
		
		//입점 신청 후 
//		if(loginOk.getMer_isbrand().equals("f")) {
//			String msg = "입점 신청 후 이용 바랍니다.";
//			String url = "/merchant/home";
//			req.setAttribute("msg", msg);
//			req.setAttribute("url", url);
//			return "message";
//		}
		
		req.setAttribute("allCount", storeManageService.allCount(merNum));
		req.setAttribute("waitCount", storeManageService.waitCount(merNum));
		req.setAttribute("requestCount", storeManageService.requestCount(merNum));
		req.setAttribute("cancleCount", storeManageService.cancleCount(merNum));
		req.setAttribute("requestCancle", storeManageService.requestCancle(merNum));
		req.setAttribute("saleOk", storeManageService.saleOk(merNum));
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
