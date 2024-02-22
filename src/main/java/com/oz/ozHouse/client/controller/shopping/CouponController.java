package com.oz.ozHouse.client.controller.shopping;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.oz.ozHouse.client.security.MemberSecurityDTO;
import com.oz.ozHouse.client.service.CouponService;
import com.oz.ozHouse.dto.MerCouponDTO;
import com.oz.ozHouse.dto.UserCouponDTO;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
@Validated
@RequiredArgsConstructor
public class CouponController {
    
	private final CouponService couponService;
	
	// setMessage 메서드
    private String setMessage (HttpServletRequest req, String url, String msg) {
    	req.setAttribute("url", msg);
    	req.setAttribute("msg", url);
    	
    	return "message";
    }
	
	@PreAuthorize("hasAnyRole('ROLE_CLIENT')")
    @GetMapping("/mypage/{memberId}/coupon")
    public String mypage_coupon(HttpServletRequest req,
    							@PathVariable("memberId") String memberId,
    							@AuthenticationPrincipal MemberSecurityDTO member) {
    	
    	List<MerCouponDTO> userCoupons = couponService.getUserCoupons(member.getUsername());
    	List<MerCouponDTO> merCoupons = couponService.getAllCoupons();
    	
    	req.setAttribute("userCoupons", userCoupons);
    	req.setAttribute("merCoupons", merCoupons);
    	
        return "client/mypage/mypage_coupon";
    }
    
	@PreAuthorize("hasAnyRole('ROLE_CLIENT')")
    @GetMapping("/mypage/coupon/{merCouponNum}")
    public String mypage_usercoupon(HttpServletRequest req,
    								@PathVariable("merCouponNum") int merCouponNum,
    								@AuthenticationPrincipal MemberSecurityDTO member) {
		
		boolean isAdd = couponService.addCoupon(member.getUsername(), merCouponNum);
		
		if (!isAdd) return setMessage(req, "이미 보유 중인 쿠폰입니다", "/mypage/" + member.getUsername() + "/coupon");
		
		return "redirect:/mypage/" + member.getUsername() + "/coupon";
    }
}
