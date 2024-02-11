package com.oz.ozHouse.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequiredArgsConstructor
public class LoginController {
	@GetMapping("/member/login")
	public String loginGet() {
		log.info("login get...............");
		return "client/member/member_login";
	}

	
	/*
	@RequestMapping(value="/member_find.do", method=RequestMethod.GET)
	public String searchMember() {
		return "client/member/member_find";
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
