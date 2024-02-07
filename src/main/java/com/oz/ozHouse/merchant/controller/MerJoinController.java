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
@RequestMapping("/merchant")
@RequiredArgsConstructor
public class MerJoinController {
	private final MerJoinService merJoinService;
	private final EmailService emailService;
	
	static final String BUSINESSFILEPATH = 
			"/Users/choejiyeong/git/ozHouse/src/main/resources/static/merchant/business";

	@GetMapping("join")
	public String merchantJoin() {
		return "merchant/join/merchant_join";
	}
	
	private String goToMessage(HttpServletRequest req, String url, String msg) {
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
	
	@PostMapping(value="send-email")
    public String merchantEmailAuth(HttpServletRequest req) throws Exception  {  
		boolean comNumCheck = checkComNum(req);
    	if(!comNumCheck) {
    		goToMessage(req, "merchant_login.do", "이미 가입된 사업자등록번호 입니다.");
    	}
    	String email = req.getParameter("merEmail");
    	boolean emailCheck = checkEmail(email);
        if (!emailCheck) {
        	goToMessage(req, "merchant_join.do", "이미 가입되어있는 이메일주소입니다.");
        }
        HttpSession session = req.getSession();
        boolean checkSaveFile = saveReg(req, session);
        if (!checkSaveFile) {
        	goToMessage(req, "merchant_main.do", "회원가입 실패 : 사업자등록증 전송 중 오류가 발생하였습니다.");
        }
		String checkNum = emailService.sendOauthMessage(email);
		MerchantDTO dto = new MerchantDTO(req);
		req.setAttribute("checkNum", checkNum);
		req.setAttribute("email", email);
		session.setAttribute("insertMerchant", dto);
		return "merchant/join/merchant_join_check";
	}

	@PostMapping("email_join_check")
	public void emailAuthCheck(HttpServletRequest req)
			throws IllegalStateException, IOException {
		HttpSession session = req.getSession();
		String saveName = (String) session.getAttribute("saveName");
		File deleteFile = new File(BUSINESSFILEPATH + saveName);
		if (req.getParameter("checkNum").equals(req.getParameter("checkNumCheck"))) {
			MerchantDTO dto = (MerchantDTO) session.getAttribute("insertMerchant");
//        	String passwd = dto.getMer_pw();
//        	dto.setMer_pw(passwordEncoder.encode(passwd));

			MerchantDTO.builder()
			.merRegistration(saveName);
			System.out.println("JoinController -> dto사업자등록증" + dto.getMerRegistration());
			int res = merJoinService.insertMerchant(dto);
			if (res > 0) {
				goToMessage(req, "merchant_main.do", "회원가입 성공 : 로그인해 주시기 바랍니다.");
			} else if (res < 0) {
				if (deleteFile.exists()) {
					deleteFile.delete();
				}
				goToMessage(req, "merchant_main.do", "회원가입 실패 : 회원가입시 오류가 발생하였습니다. 관리자에게 문의하여주세요");
			}
		} else {
			if (deleteFile.exists()) {
				deleteFile.delete();
				goToMessage(req, "merchant_join.do", "인증번호가 올바르지 않습니다.");
			}
		}
	}

	public boolean isValid(String str) {
        return Pattern.matches("^[a-zA-Z0-9-_]*$", str);
    }

	@PostMapping("check-id")
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