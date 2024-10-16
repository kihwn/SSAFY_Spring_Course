package com.ssafy.mvc.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//로그인 여부 체크
		//세션에 로그인 여부가 등록되어 있고, request에 세션이 들어있음.
		HttpSession session= request.getSession();
		if (session.getAttribute("loginUser")==null) {
			response.sendRedirect("login");
			return false;
		}
		return true;
	}

}
