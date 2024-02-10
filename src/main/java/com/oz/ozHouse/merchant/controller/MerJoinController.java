package com.oz.ozHouse.merchant.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.oz.ozHouse.client.service.EmailService;
import com.oz.ozHouse.dto.MerchantDTO;
import com.oz.ozHouse.merchant.service.MerJoinService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/merchant/login")
@RequiredArgsConstructor
public class MerJoinController {
	private final MerJoinService merJoinService;
	private final EmailService emailService;
	
	static final String BUSINESSFILEPATH = 
			"/Users/choejiyeong/git/ozHouse/src/main/resources/static/merchant/business";

	@GetMapping("/join")
	public String merchantJoin() {
		return "merchant/join/merchant_join";
	}
	
	private HttpServletRequest goToMessage(HttpServletRequest req, String url, String msg) {
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return req;
	}
	
	// 사업자등록번호 중복 확인
	private boolean checkComNum(HttpServletRequest req) {
		boolean comNumcheck = merJoinService.merchant_checkBsNum(req.getParameter("merComnum1"),
				req.getParameter("merComnum2"), req.getParameter("merComnum3"));
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
        MultipartFile mFile = mr.getFile("merRegistration");
    	if (mFile != null && mFile.getSize() > 0) {
    		String saveName = mFile.getOriginalFilename() + "_" + req.getParameter("merComnum1") + 
    				req.getParameter("merComnum2") + req.getParameter("merComnum3");
    		File file = new File(BUSINESSFILEPATH + "/" + saveName);
    		mFile.transferTo(file); //             
	        session.setAttribute("saveName", saveName);
	        return true;
    	}else {
    		return false;
        }
	}
	
	@PostMapping("/join/send-email")
    public String merchantEmailAuth(HttpServletRequest req) throws Exception  {  
		boolean comNumCheck = checkComNum(req);
    	if(comNumCheck) {
    		req = goToMessage(req, "/merchant/login", "이미 가입된 사업자등록번호 입니다.");
    		return "message";
    	}
    	String email = req.getParameter("merEmail");
    	boolean emailCheck = checkEmail(email);
        if (emailCheck) {
        	req = goToMessage(req, "/merchant/login/join", "이미 가입되어있는 이메일주소입니다.");
        	return "message";
        }
        HttpSession session = req.getSession();
        boolean checkSaveFile = saveReg(req, session);
        if (!checkSaveFile) {
        	req = goToMessage(req, "/merchant/login/join", "회원가입 실패 : 사업자등록증 전송 중 오류가 발생하였습니다.");
        	return "message";
        }
		String checkNum = emailService.sendOauthMessage(email);
		MerchantDTO dto = new MerchantDTO(req);
		req.setAttribute("checkNum", checkNum);
		req.setAttribute("email", email);
		session.setAttribute("insertMerchant", dto);
		return "merchant/join/merchant_join_check";
	}

	@PostMapping("/join/email-verification")
	public String emailAuthCheck(HttpServletRequest req)
			throws IllegalStateException, IOException {
		HttpSession session = req.getSession();
		String saveName = (String) session.getAttribute("saveName");
		File deleteFile = new File(BUSINESSFILEPATH + saveName);
		if (req.getParameter("checkNum").equals(req.getParameter("checkNumCheck"))) {
			MerchantDTO dto = (MerchantDTO) session.getAttribute("insertMerchant");

			dto.setMerRegistration(saveName);
			System.out.println("saveName : " + saveName);
			System.out.println("JoinController -> dto사업자등록증" + dto.getMerRegistration());
			String id = merJoinService.insertMerchant(dto);
			if (id != null) {
				req = goToMessage(req, "/merchant/main", "회원가입 성공 : " + id + "님, 로그인해 주시기 바랍니다.");
			} else if (id == null) {
				if (deleteFile.exists()) {
					deleteFile.delete();
				}
				req = goToMessage(req, "/merchant/main", "회원가입 실패 : 회원가입시 오류가 발생하였습니다. 관리자에게 문의하여주세요");
			}
		} else {
			if (deleteFile.exists()) {
				deleteFile.delete();
				req = goToMessage(req, "/merchant/login/join", "인증번호가 올바르지 않습니다.");
			}
		}
		return "message";
	}

	public boolean isValid(String str) {
        return Pattern.matches("^[a-zA-Z0-9-_]*$", str);
    }

	@PostMapping("/join/check-id")
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