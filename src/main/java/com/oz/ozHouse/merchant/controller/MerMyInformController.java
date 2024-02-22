package com.oz.ozHouse.merchant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oz.ozHouse.dto.MerchantDTO;
import com.oz.ozHouse.merchant.config.MerchantLoginBean;
import com.oz.ozHouse.merchant.exception.NotFoundMerNumException;
import com.oz.ozHouse.merchant.service.MerMyInformService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
		return "merchant/myInform/myInform_view";
	}

	@PostMapping("/{merNum}/check")
	public String myInform_update(HttpServletRequest req, @PathVariable("merNum") int merNum, 
			@RequestParam(name="mode") String mode) {
		req.setAttribute("mode", mode);
		HttpSession session = req.getSession();
		MerchantLoginBean loginOk = (MerchantLoginBean)session.getAttribute("merLoginMember");
		req.setAttribute("sessionId", loginOk.getMerId());
		req.setAttribute("sessionPw", loginOk.getMerPw());
		return "merchant/myInform/myInform_updateCheck";
	}
	
	@GetMapping("/{merNum}/password")
	public String myInformUpdatePass() {
		return "merchant/myInform/myInform_updatePass";
	}
	
	@GetMapping("/{merNum}/modfy")
	public String myInform_updateForm(HttpServletRequest req, @ModelAttribute MerchantDTO dto) {
		return "merchant/myInform/myInform_update";
	}
	
	@GetMapping("/{merNum}/out")
	public String memberOut(HttpServletRequest req, HttpServletResponse resp, String mer_num) {
//		int res = myInformMapper.memberOut(mer_num);
//		String msg, url = null;
//		if(res>0) {
//			msg = "회원탈퇴가 완료되었습니다. 판매자님의 정보는 5년 후 폐기될 예정입니다.";
//			url = "merchant_main.do";
//			HttpSession session = req.getSession();
//	    	session.invalidate();
//	    	Cookie ck = new Cookie("saveId", null);
//	    	ck.setMaxAge(0);
//	    	resp.addCookie(ck);              
//		}else {
//			msg = "회원탈퇴 중 오류가 발생하였습니다.";
//			url = "myInform_view.do?mer_num=" + mer_num;
//		}
//		req.setAttribute("msg", msg);
//		req.setAttribute("url", url);
//		return "forward:message.jsp";
		return null;
	}
}
