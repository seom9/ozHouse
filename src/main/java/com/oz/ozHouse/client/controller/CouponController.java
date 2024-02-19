package com.oz.ozHouse.client.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.oz.ozHouse.client.security.MemberSecurityDTO;
import com.oz.ozHouse.client.service.CouponService;
import com.oz.ozHouse.client.service.EmailService;
import com.oz.ozHouse.client.service.MypageService;
import com.oz.ozHouse.dto.MerCouponDTO;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
@Validated
@RequiredArgsConstructor
public class CouponController {
    
	private final CouponService couponService;
	
	@PreAuthorize("hasAnyRole('ROLE_CLIENT')")
    @GetMapping("mypage/{memberId}/coupon")
    public String mypage_coupon(HttpServletRequest req,
    								@PathVariable("memberId") String memberId) {
    	
    	List<MerCouponDTO> userCoupons = couponService.getUserCoupons(memberId);
    	List<MerCouponDTO> merCoupons = couponService.getAllCoupons();
    	
    	req.setAttribute("userCoupons", userCoupons);
    	req.setAttribute("merCoupons", merCoupons);
    	
        return "client/mypage/mypage_coupon";
    }
    
//    @RequestMapping(value = "mypage_usercoupon.do", method = RequestMethod.GET)
//    public String mypage_usercoupon(HttpServletRequest req) {
//    	int mer_couponnum = Integer.parseInt(req.getParameter("mer_couponnum"));
//    	int mer_num = Integer.parseInt(req.getParameter("mer_num"));
//    	String end = req.getParameter("enddate");
//    	User_CouponDTO dto = new User_CouponDTO();
//    	dto.setMember_num(getMemberNum(req));
//    	dto.setMer_coupon_num(mer_couponnum);
//    	dto.setMer_num(mer_num);
//    	dto.setUser_coupon_active("f");
//    	dto.setMer_couponenddate(end);
//    	int res = mypageMapper.insertUserCoupon(dto);
//		if (res>0) {
//			req.setAttribute("msg", "쿠폰 받기 성공");
//			req.setAttribute("url", "mypage_coupon.do");
//		}else if (res<0){
//			req.setAttribute("msg", "쿠폰 받기 실패");
//			req.setAttribute("url", "mypage_coupon.do");
//		}
//    	return "message";
//    }
}
