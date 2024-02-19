package com.oz.ozHouse.merchant.Interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false); // 세션이 없으면 null 반환
        if (session == null || session.getAttribute("merLoginMember") == null) {
            response.sendRedirect("/merchant/message"); // 로그인 페이지로 리다이렉션
            return false; // 컨트롤러 메서드 실행 중단
        }
        return true; // 컨트롤러 메서드 실행 계속
    }
}
