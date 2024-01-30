package com.oz.ozHouse.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MemberController {
	@GetMapping("/member_login.do")
	public String index() {
		return "client/member/member_login";
	}
	
    @GetMapping(value = "/member_join.do")
    public String member_join() {
        return "client/member/member_join";
    }
}
