package com.oz.ozHouse.merchant.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.oz.ozHouse.client.service.EmailServiceImpl;
import com.oz.ozHouse.dto.MerchantDTO;
import com.oz.ozHouse.merchant.service.MerJoinServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MerJoinController {
	private final MerJoinServiceImpl merJoinService;
	
	static final String BUSINESSFILEPATH = 
			"C:\\Users\\moonj\\Desktop\\ozHouse\\ozHouse\\src\\main\\webapp\\resources\\merchant\\business";

	@GetMapping("merchant_join.do")
	public String merchantJoin() {
		return "merchant/join/merchant_join";
	}
	
	private String goToMessege(HttpServletRequest req, String url, String msg) {
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message";
	}
	
	// 사업자등록번호 중복 확인
	private boolean checkComNum(HttpServletRequest req) {
		Map<String, String> comNum = new HashMap<String, String>();
		comNum.put("merComnum1",req.getParameter("merComnum1"));
		comNum.put("merComnum2",req.getParameter("merComnum2"));
		comNum.put("merComnum3",req.getParameter("merComnum3"));
		System.out.println("Controller -> merComnum : " + comNum.get("merComnum1") + "-" + comNum.get("merComnum2")
				+ "-" + comNum.get("merComnum3"));
		boolean comNumcheck = merJoinService.merchant_checkBsNum(comNum);
		return comNumcheck;
	}
	
	//이메일 중복 확인
	private boolean checkEmail(String email) {
    	boolean emailCheck = merJoinService.merchant_checkEmail(email);
    	return emailCheck;
	}
	
	//사업자등록증 저장
	private boolean saveReg(HttpServletRequest req, HttpSession session) throws IllegalStateException, IOException{
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest)req;
        MultipartFile mFile = mr.getFile("mer_business_registration");
    	if (mFile != null && mFile.getSize() > 0) {
    		String saveName = mFile.getOriginalFilename();
    		File file = new File(BUSINESSFILEPATH + saveName);
    		mFile.transferTo(file); //             
	        session.setAttribute("saveName", saveName);
	        return true;
    	}else {
    		return false;
        }
	}
	
	@PostMapping(value="/merchant_send_email.do")
    public String merchantEmailAuth(HttpServletRequest req) throws IllegalStateException, IOException  {  //dto 뿉 MultipertFile 쓣 諛쏅뒗 怨쇱젙 뿉 꽌 BindingException 諛쒖깮, BindingResult濡   옟 쓬
		boolean checkNum = checkComNum(req);
    	if(!checkNum) {
    		goToMessege(req, "merchant_login.do", "이미 가입된 사업자등록번호 입니다.");
    	}
    	String email = req.getParameter("mer_email");
    	boolean emailCheck = checkEmail(email);
        if (!emailCheck) {
        	goToMessege(req, "merchant_join.do", "이미 가입되어있는 이메일주소입니다.");
        }
        HttpSession session = req.getSession();
        boolean checkSaveFile = saveReg(req, session);
        if (!checkSaveFile) {
        	goToMessege(req, "merchant_main.do", "회원가입 실패 : 사업자등록증 전송 중 오류가 발생하였습니다.");
        }
		EmailServiceImpl emailService = new EmailServiceImpl();
        String num = null;
		try {
			num = emailService.sendOauthMessage(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// String checkNum = Integer.toString(num);
		MerchantDTO dto = new MerchantDTO(req);
		req.setAttribute("checkNum", num);
		req.setAttribute("email", email);
		session.setAttribute("insertMerchant", dto);
		return "merchant/join/merchant_join_check";
	}
	
	public boolean isValid(String str) {
        return Pattern.matches("^[a-zA-Z0-9-_]*$", str);
    }

	@PostMapping("mer-checkId.do")
	@ResponseBody
	public String checkId(@RequestBody MultiValueMap<String, String> map) {
		String id = map.get("merId").get(0);
		String result = "N";
		if (merJoinService.merchant_checkMerId(id) != null)
			result = "Y";
		if (id.trim().equals(""))
			result = "E"; 
		if (id.length() < 5 || id.length() > 12)
			result = "L";
		if (isValid(id) == false)
			result = "V";
		return result;
	}
}