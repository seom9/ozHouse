package com.oz.ozHouse.merchant.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.oz.ozHouse.client.service.EmailService;
import com.oz.ozHouse.client.service.MemberService;
import com.oz.ozHouse.dto.MerchantDTO;
import com.oz.ozHouse.merchant.service.MerchantJoinServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MerchantJoinController {
	private final MerchantJoinServiceImpl merJoinService;
	
	static final String BUSINESSFILEPATH = 
			"C:\\Users\\moonj\\Desktop\\ozHouse\\ozHouse\\src\\main\\webapp\\resources\\merchant\\business";

	@GetMapping("merchant_join.do")
	public String merchantJoin() {
		return "merchant/join/merchant_join";
	}
	
	@RequestMapping(value="/merchant_send_email.do")
    public String merchantEmailAuth(HttpServletRequest req, @ModelAttribute MerchantDTO dto, 
    		BindingResult result) throws IllegalStateException, IOException {  //dto 뿉 MultipertFile 쓣 諛쏅뒗 怨쇱젙 뿉 꽌 BindingException 諛쒖깮, BindingResult濡   옟 쓬
		//사업자등록번호 중복 확인
		Map<String, String> comNum = new HashMap<String, String>();
		comNum.put("merComnum1", dto.getMerComnum1());
    	comNum.put("merComnum2", dto.getMerComnum2());
    	comNum.put("merComnum3", dto.getMerComnum3());
    	boolean comNumcheck  = merJoinService.merchant_checkBsNum(comNum);
    	if(!comNumcheck) {
    		String msg = "이미 가입된 사업자등록번호 입니다.";
    		String url = "merchant_login.do";
    		req.setAttribute("msg", msg);
			req.setAttribute("url", url);
    		return "message";
    	}
    	
    	//이메일 중복 확인
    	String email = req.getParameter("mer_email");
    	boolean emailCheck = merJoinService.merchant_checkEmail(email);
		
        if (!emailCheck) {
			req.setAttribute("msg", "이미 가입되어있는 이메일주소입니다.");
			req.setAttribute("url", "merchant_join.do");
			return "message";
        }
        
        HttpSession session = req.getSession();
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest)req;
        MultipartFile mFile = mr.getFile("mer_business_registration");
    	if (mFile != null && mFile.getSize() > 0) {
    		String saveName = mFile.getOriginalFilename();
    		File file = new File(BUSINESSFILEPATH + saveName);
    		mFile.transferTo(file); //             
	        session.setAttribute("saveName", saveName);
    	}else {
    		req.setAttribute("msg", "회원가입 실패 : 사업자등록증 전송 중 오류가 발생하였습니다.");
			req.setAttribute("url", "merchant_main.do");
			return "message";
        }
        
        String ad1 = req.getParameter("sample6_address");
		String ad2 = req.getParameter("sample6_detailAddress");
		String ad3 = req.getParameter("sample6_extraAddress");
		dto.setMer_business_adress(ad1 + "/" + ad2 + "/" + ad3);
        
        int num = TSL.sendEmailCheck(email);
        String checkNum = Integer.toString(num);
        req.setAttribute("checkNum", checkNum);
        req.setAttribute("email", email);
        session.setAttribute("insertMerchant", dto);
        return "merchant/join/merchant_join_check";
    }
}