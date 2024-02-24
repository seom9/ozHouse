package com.oz.ozHouse.merchant.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oz.ozHouse.dto.InsertMerCouponDTO;
import com.oz.ozHouse.dto.MerCouponDTO;
import com.oz.ozHouse.merchant.service.MerCouponService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/merchant/{merNum}/store")
public class MerCouponController {
	private final MerCouponService couponService;
	
	@GetMapping("/coupons")
	public String couponInputView(HttpServletRequest req, @PathVariable("merNum") int merNum) {
		req.setAttribute("merNum", merNum);
		return "merchant/store/coupon/coupon_insert";
	}
	
	@PostMapping("/coupons/insert")
	public String couponInputOk(HttpServletRequest req, HttpServletResponse resp,
			@ModelAttribute InsertMerCouponDTO dto) throws UnsupportedEncodingException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		int res = couponService.merCouponInsert(dto);
		String msg = null;
		String url = null;
		if (res > 0) {
			msg = "쿠폰 등록 신청이 완료되었습니다.";
			url = "/merchant/" + dto.getMerNum() + "/store/coupons/list";
		}else {
			msg = "쿠폰 등록 신청이 완료되지 않았습니다.";
			url = "/merchant/" + dto.getMerNum() + "/store/coupons/insert";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message";
	}
	
	@GetMapping("/coupons/list")
	public String couponList(HttpServletRequest req, @PathVariable("merNum") int merNum) {
		List<MerCouponDTO> list = couponService.searchCouponList(merNum);
		int couponCount = list.size();
		req.setAttribute("check", "all");
		req.setAttribute("radio", "all");
		req.setAttribute("merNum", merNum);
		req.setAttribute("couponList", list);
		req.setAttribute("couponCount", couponCount);
		return "merchant/store/coupon/coupon_list";
	}

	@GetMapping("/coupons/{merCouponnum}")
	public String couponDelete(HttpServletRequest req, @PathVariable("merCouponnum") int merCouponnum, 
			@PathVariable("merNum")int merNum) {
		int res = couponService.merCouponDelete(merCouponnum);
		String msg = null;
		String url = "/merchant/" + merNum + "/store/coupons/list";
		if (res > 0) {
			msg = "쿠폰삭제가 완료되었습니다.";
		}else {
			msg = "쿠폰삭제가 완료되지 않았습니다.";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message";
	}
}
