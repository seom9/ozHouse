package com.oz.ozHouse.client.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oz.ozHouse.client.config.LoginOkBean;
import com.oz.ozHouse.client.service.EmailService;
import com.oz.ozHouse.client.service.MemberService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {
	private final MemberService memberService;
	private final PasswordEncoder passwordEncoder;
	
	@PostMapping("/{member_id}")
	public String loginOk(HttpServletRequest req, HttpServletResponse resp, 
			@ModelAttribute LoginOkBean loginOk, @PathVariable("member_id") String saveId) {
		
//		if (memberMapper.confirmDelete(loginOk.getMember_id()) != null) {
//			req.setAttribute("msg", "탈퇴한 아이디입니다");
//			req.setAttribute("url", "main.do");
//			return "message";
//		}
		
		int res = loginOk.loginOk(memberService, passwordEncoder);
		
		String msg = null, url = null;
		
		switch(res){
		case LoginOkBean.OK :
			Cookie ck = new Cookie("saveId", loginOk.getMember_id());
			if (saveId != null) {
				ck.setMaxAge(7*24*60*60);
			}else {
				ck.setMaxAge(0);
			}
			resp.addCookie(ck);
			HttpSession session = req.getSession();
			session.setAttribute("loginMember", loginOk);
			msg = loginOk.getMember_id() + "님, 방문해 주셔서 감사합니다";
			url = "/main";
			break;
		case LoginOkBean.NOT_ID :
			msg = "아이디를 확인해 주세요";
			url = "/main";
			break;
		case LoginOkBean.NOT_PW :
			msg = "비밀번호를 확인해 주세요";
			url = "/main";
			break;
		case LoginOkBean.ERROR : 
			msg = "서버 오류입니다 관리자에게 문의해 주세요";
			url = "/main";
			break;
		}
		
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message";
	}
	
	/*
	@RequestMapping(value="/member_find.do", method=RequestMethod.GET)
	public String searchMember() {
		return "client/member/member_find";
	}
	
	// 이메일 형식 검증
    private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9_+&*-]+(?:\\." +
            "[a-zA-Z0-9_+&*-]+)*@" +
            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
            "A-Z]{2,7}$";

    public static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    @RequestMapping(value="/send_find_email.do", method=RequestMethod.POST)
	public String sendEmail1(HttpServletRequest req, String member_email) {
    	String member_id = memberMapper.checkMemberIdEmail(member_email);
		if (member_id == null) {
			req.setAttribute("msg", "가입되어 있지 않은 아이디입니다");
			req.setAttribute("url", "member_find.do");
			return "message";
		}
		if (isValidEmail(member_id)) {
			req.setAttribute("msg", "간편 가입으로 가입한 계정입니다 : 간편 로그인을 이용해 주세요");
			req.setAttribute("url", "member_login.do");
			return "message";
		}
    	int oauthNum = MemberFind.sendEmailCheck(member_email, member_id);
    	req.setAttribute("oauthNum", oauthNum);
    	req.setAttribute("member_email", member_email);
		return "client/member/send_find_email";
		
    }
    
    
	@RequestMapping(value="/member_find.do", method=RequestMethod.POST)
	public String searchMember(HttpServletRequest req, String member_email) {
		String member_id = memberMapper.checkMemberIdEmail(member_email);
		
		int oauthNum = Integer.parseInt(req.getParameter("oauthNum"));
		int userSendNum = Integer.parseInt(req.getParameter("userSendNum"));
		
		if (oauthNum == userSendNum) {
			req.setAttribute("msg", "비밀번호를 재설정해 주세요");
			req.setAttribute("url", "mypage_upadatePasswd.do?mode=find&id=" + member_id);
		}else {
			req.setAttribute("msg", "인증 번호가 다릅니다 : 다시 시도해 주세요");
			req.setAttribute("url", "member_find.do");
		}
		return "message";
	}
	
	@RequestMapping("/member_logout.do")
	public String logout(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.invalidate();
		req.setAttribute("msg", "로그아웃 되었습니다");
		req.setAttribute("url", "main.do");
		return "message";
	}
	
	@RequestMapping(value="/member_login.do", method=RequestMethod.POST)
	public String loginOk(HttpServletRequest req, HttpServletResponse resp, 
			@ModelAttribute LoginOkBean loginOk, @RequestParam(required=false) String saveId) {
		if (memberMapper.confirmDelete(loginOk.getMember_id()) != null) {
			req.setAttribute("msg", "탈퇴한 아이디입니다");
			req.setAttribute("url", "main.do");
			return "message";
		}
		int res = loginOk.loginOk(memberMapper, passwordEncoder);
		String msg = null, url = null;
		switch(res){
		case LoginOkBean.OK :
			Cookie ck = new Cookie("saveId", loginOk.getMember_id());
			if (saveId != null) {
				ck.setMaxAge(7*24*60*60);
			}else {
				ck.setMaxAge(0);
			}
			resp.addCookie(ck);
			HttpSession session = req.getSession();
			session.setAttribute("loginMember", loginOk);
			msg = loginOk.getMember_id() + "님, 방문해 주셔서 감사합니다";
			url = "main.do";
			break;
		case LoginOkBean.NOT_ID :
			msg = "아이디를 확인해 주세요";
			url = "main.do";
			break;
		case LoginOkBean.NOT_PW :
			msg = "비밀번호를 확인해 주세요";
			url = "main.do";
			break;
		case LoginOkBean.ERROR : 
			msg = "서버 오류입니다 관리자에게 문의해 주세요";
			url = "main.do";
			break;
		}
		
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message";
	}
	
	
	//카카오 로그인 api
	@RequestMapping(value="/kakao_login.do", method=RequestMethod.GET)
	public String kakaoLogin(HttpServletRequest req, @RequestParam(value = "code", required = false) String code) throws Exception {
		System.out.println("#########" + code);
		String access_Token = kakaoLogin.getAccessToken(code);
		MemberDTO dto = kakaoLogin.getUserInfo(access_Token);
		HttpSession session = req.getSession();
		
		if (dto.getMember_id() == null) {
			req.setAttribute("member_email", dto.getMember_email());
			req.setAttribute("member_nickname", dto.getMember_nickname());
			req.setAttribute("member_image", dto.getMember_image());
			session.setAttribute("insertMember", dto);
			return "client/member/member_join";
		}else {
			LoginOkBean loginOk = new LoginOkBean();
			loginOk.setMember_id(dto.getMember_id());
			
			if (memberMapper.confirmDelete(loginOk.getMember_id()) != null) {
				req.setAttribute("msg", "탈퇴한 아이디입니다");
				req.setAttribute("url", "main.do");
				return "message";
			}
			
			session.setAttribute("loginMember", loginOk);
			req.setAttribute("msg", loginOk.getMember_id() + "님, 방문해 주셔서 감사합니다");
			req.setAttribute("url", "main.do");
			return "message";
		}
	}
	
	
	// 네이버 로그인 api
    @RequestMapping(value = "/naverLogin.do", method = { RequestMethod.GET, RequestMethod.POST })
    public String login(HttpServletRequest req) {
    	HttpSession session = req.getSession();
        String naverAuthUrl = naverLogin.getAuthorizationUrl(session);
        
        //https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=sE***************&
        //redirect_uri=http%3A%2F%2F211.63.89.90%3A8090%2Flogin_project%2Fcallback&state=e68c269c-5ba9-4c31-85da-54c16c658125
        System.out.println(" 꽕 씠踰  : " + naverAuthUrl);
        
        return "redirect:"+naverAuthUrl;
    }

    // 네이버 로그인 callback
    @RequestMapping(value = "/callBack.do", method = { RequestMethod.GET, RequestMethod.POST })
    public String callback(HttpServletRequest req, @RequestParam String code, @RequestParam String state, HttpSession session)
            throws IOException, ParseException {
        OAuth2AccessToken oauthToken;
        oauthToken = naverLogin.getAccessToken(session, code, state);

        String apiResult = naverLogin.getUserProfile(oauthToken);
        System.out.println(naverLogin.getUserProfile(oauthToken).toString());
        System.out.println("result"+apiResult);
        
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(apiResult);		
		JSONObject jsonObj = (JSONObject) obj;
        
		JSONObject response_obj = (JSONObject)jsonObj.get("response");
		String naverId = (String)response_obj.get("id");
		String naverNickname = (String)response_obj.get("nickname");
		String naverEmail = (String)response_obj.get("email");
		String naverProfile_image = (String)response_obj.get("profile_image");
        
		MemberDTO dto = memberMapper.checkNaver(naverEmail);
		
		if (dto !=null) {
			LoginOkBean loginOk = new LoginOkBean();
			loginOk.setMember_id(dto.getMember_id());
			
			if (memberMapper.confirmDelete(loginOk.getMember_id()) != null) {
				req.setAttribute("msg", "탈퇴한 아이디입니다");
				req.setAttribute("url", "main.do");
				return "message";
			}
			
			session.setAttribute("loginMember", loginOk);
			req.setAttribute("msg", loginOk.getMember_id() + "님, 방문해 주셔서 감사합니다");
			req.setAttribute("url", "main.do");
			return "message";
		}


        req.setAttribute("member_nickname", naverNickname);
        req.setAttribute("member_email", naverEmail);
        
        
        if (naverProfile_image != null) {
        	req.setAttribute("member_image", naverProfile_image);
        }
        
        return "client/member/member_join";
    }
	*/
}
