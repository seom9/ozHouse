package com.oz.ozHouse.merchant.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.oz.ozHouse.client.service.EmailService;
import com.oz.ozHouse.dto.MerchantDTO;
import com.oz.ozHouse.merchant.config.MerchantLoginBean;
import com.oz.ozHouse.merchant.service.MerLoginService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/merchant")
public class MerLoginController {
	private final MerLoginService loginService;
	private final EmailService emailService;
	private final PasswordEncoder passwordEncoder;

	@GetMapping("/login")
	public String login() {
		return "merchant/join/merchant_login";
	}

	@PostMapping("/login/loginOk")
	public String loginOk(HttpServletRequest req, HttpServletResponse resp, @ModelAttribute MerchantLoginBean loginOk,
			@RequestParam(name = "saveId", required = false) String saveId) {
		int res = loginOk.loginOk(loginService, passwordEncoder);
		String msg = null, url = null;
		switch (res) {
		case MerchantLoginBean.OK:
			Cookie ck = new Cookie("saveId", loginOk.getMerId());
			if (saveId != null) {
				ck.setMaxAge(7 * 24 * 60 * 60);
			} else {
				ck.setMaxAge(0);
			}
			resp.addCookie(ck);
			HttpSession session = req.getSession();
			session.setAttribute("merLoginMember", loginOk);
			msg = loginOk.getMerId() + "님, OZ의 집에 오신걸 환영합니다.";
			url = "/merchant/home";
			break;
		case MerchantLoginBean.NOT_ID:
			msg = "아이디 확인 후 다시 시도해 주세요";
			url = "/merchant/login";
			break;
		case MerchantLoginBean.NOT_PW:
			msg = "비밀번호 확인 후 다시 시도해 주세요";
			url = "/merchant/login";
			break;
		case MerchantLoginBean.ERROR:
			msg = "DB 접속 오류! 관리자에게 문의해 주세요";
			url = "/merchant/home";
			break;
		case MerchantLoginBean.DELETE_ID:
			msg = "사용 중지된 ID입니다.";
			url = "/merchant/home";
			break;
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message";
	}

	@GetMapping(value = "/login/logout")
	public String logout(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.invalidate();
		String msg = "로그아웃 되었습니다.";
		String url = "/merchant/home";
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message";
	}

	@GetMapping("/login/findMerchant")
	public String findMerchant() {
		return "merchant/join/merchant_find";
	}

	@PostMapping(value = "/login/sendEmail")
	public String sendEmail1(HttpServletRequest req, @RequestParam(name = "merEmail") String merEmail)
			throws Exception {
		String mer_id = loginService.checkMerchantIdEmail(merEmail);
		if (mer_id == null) {
			req.setAttribute("msg", "가입되어 있지 않은 Email입니다");
			req.setAttribute("url", "/merchant/login/findMerchant");
			return "message";
		}

		String oauthNum = emailService.sendOauthMessage(merEmail);
		req.setAttribute("oauthNum", oauthNum);
		req.setAttribute("member_email", merEmail);
		return "merchant/join/merchant_send_find_email";
	}

	@PostMapping(value = "/login/find")
	public String searchMember(HttpServletRequest req, @RequestParam(name = "merEmail") String mer_email) {
		String memberId = loginService.checkMerchantIdEmail(mer_email);

		String oauthNum = req.getParameter("oauthNum");
		String userSendNum = req.getParameter("userSendNum");

		if (oauthNum.equals(userSendNum)) {
			req.setAttribute("msg", "비밀번호를 재설정해 주세요");
			req.setAttribute("url", "changePass/" + memberId);
		} else {
			req.setAttribute("msg", "인증 번호가 다릅니다 : 다시 시도해 주세요");
			req.setAttribute("url", "find");
		}
		return "message";
	}

	@GetMapping(value = "/login/changePass/{memberId}")
	public String mypage_updatePasswd(HttpServletRequest req, @PathVariable("memberId") String memberId) {
		req.setAttribute("member_id", memberId);
		return "merchant/join/merchant_changePass";
	}

	@PostMapping(value = "/login/putPassword/{member_id}")
	public String mypage_updatePasswdPro(HttpServletRequest req, @PathVariable("member_id") String member_id,
			@RequestParam(name = "new_member_passwd") String new_member_passwd) {
		new_member_passwd = passwordEncoder.encode(new_member_passwd);
		int res = loginService.updatePass(new_member_passwd, member_id);
		if (res > 0) {
			req.setAttribute("msg", "비밀번호가 업데이트 되었습니다");
			req.setAttribute("url", "/merchant/login");
		} else {
			req.setAttribute("msg", "비밀번호 업데이트 실패 : 수정하실 비밀번호를 확인해 주세요");
			req.setAttribute("url", "/merchant/login");
		}
		return "message";
	}

}
