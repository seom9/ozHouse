package com.oz.ozHouse.merchant.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.oz.ozHouse.domain.Merchant;
import com.oz.ozHouse.dto.MerchantDTO;
import com.oz.ozHouse.dto.merchant.MerchantUpdateDTO;
import com.oz.ozHouse.merchant.config.MerchantLoginBean;
import com.oz.ozHouse.merchant.exception.NotFoundMerNumException;
import com.oz.ozHouse.merchant.service.MerMyInformService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/merchant/home/myinfo")
@RequiredArgsConstructor
public class MerMyInformController {
	private final MerMyInformService myService;
	private final PasswordEncoder passwordEncoder;

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
	
	@PostMapping("/{merNum}/password/ok")
	public String myInformUpdatePassOk(HttpServletRequest req, 
			@RequestParam(name="merPw") String merPw,
			@PathVariable("merNum") int merNum) {
		merPw = passwordEncoder.encode(merPw);
		int res = myService.updatePass(merPw, merNum);
		String msg = null, url = null;
		
		if(res>0) {
			msg = "비밀번호 변경이 완료되었습니다. 다시 로그인 해주세요.";
			HttpSession session = req.getSession();
			session.invalidate();
			url = "/merchant/home";
		}else {
			msg = "비밀번호 변경 중 오류가 발생하였습니다.";
			url = "/merchant/home/myinfo/" + merNum;
		}
		req = goToMessage(req, url, msg);
		return "message";
	}
	
	@GetMapping("/{merNum}/modfy")
	public String myInform_updateForm(HttpServletRequest req) {
		return "merchant/myInform/myInform_update";
	}
	
	private String setAdress(HttpServletRequest req) {
		String ad1 = req.getParameter("sample6_address");
		String ad2 = req.getParameter("sample6_detailAddress");
		String ad3 = req.getParameter("sample6_extraAddress");
		return ad1 + "/" + ad2 + "/" + ad3;
		
	}
	
	private HttpServletRequest goToMessage(HttpServletRequest req, String url, String msg) {
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return req;
	}
	
	private boolean sendFile(MultipartFile mf, String path, String fileName) {
		File file = new File(path + fileName);
		try {
			mf.transferTo(file);
		}catch(IOException e) {
			return false;
		}
		return true;
	}
	
	private void deleteFile(String path) {
		File deleteFile = new File(path);
		if (deleteFile.exists()){
			deleteFile.delete();
		}
	}
	
	private String savedFileName(
				MultipartFile mf, MerchantUpdateDTO dto, String oldName, String path) {
		if (mf == null || mf.getSize()<=0) {
			return oldName;
		}else {
			String FileName = dto.getMerComnum1()+ dto.getMerComnum2()+ dto.getMerComnum3() + "_" + mf.getOriginalFilename();
			if(!sendFile(mf, path, FileName)) {
				String savedName = null;
				return savedName;
			}
			deleteFile(path + oldName);
			return FileName;
		}
	}
	
	@PostMapping("/{merNum}/modfy/ok")
	public String myInform_updateFormOk(HttpServletRequest req, @ModelAttribute MerchantUpdateDTO dto,
			BindingResult result) throws IllegalStateException, IOException {
		String url = "/merchant/home/myinfo/" + dto.getMerNum();
		dto.setMerAdress(setAdress(req));
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest)req;
		
		String ole_business = req.getParameter("old_mer_business_registration");
		MultipartFile business = mr.getFile("merRegistration");
		String busName = savedFileName(business, dto, ole_business, MerJoinController.BUSINESSFILEPATH);
		if(busName == null) {
			req = goToMessage(req, url, "사업자등록증 수정 중 오류가 발생하였습니다.");
			return "message";
		}else {
			dto.setMerRegistration(busName);
		}
        
		System.out.println("판매자 정보 업데이트 전에 기존 정보 불러오기(Inform)");
        Merchant merchant = myService.getMerchant(dto.getMerNum());
		String res = myService.updateMerchant(dto, merchant);
		if(res != null) {
			req.setAttribute("msg",res + "님의 정보 수정이 완료되었습니다.");
		}else {
			req.setAttribute("msg","정보 수정을 완료하지 못하였습니다.");
		}
		req.setAttribute("url", url);
		return "message";
	}
	
	@GetMapping("/{merNum}/out")
	public String memberOut(HttpServletRequest req, HttpServletResponse resp, 
			@PathVariable("merNum") int merNum) {
		int res = myService.merchantOut(merNum);
		String msg, url = null;
		if(res>0) {
			msg = "회원탈퇴가 완료되었습니다. 판매자님의 정보는 5년 후 폐기될 예정입니다.";
			url = "/merchant/home";
			HttpSession session = req.getSession();
	    	session.invalidate();
	    	Cookie ck = new Cookie("saveId", null);
	    	ck.setMaxAge(0);
	    	resp.addCookie(ck);              
		}else {
			msg = "회원탈퇴 중 오류가 발생하였습니다.";
			url = "/merchant/home/myinfo/" + merNum;
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message";
	}
}
