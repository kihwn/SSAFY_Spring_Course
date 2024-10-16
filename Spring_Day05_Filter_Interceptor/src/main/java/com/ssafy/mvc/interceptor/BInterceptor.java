package com.ssafy.mvc.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//,인터셉터는 HandlerInterceptor를 구현한 클래스. 
@Component //빈으로 등록됨
public class BInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//boolean 반환 타입 / true - 계속 진행 / false 진행 stop
		System.out.println("B: pre");
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//정상적으로 수행이 됐다면 실행, 예외 발생시는 미실행
		System.out.println("B: post");
		
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//view가 전달된 후 실행 (예외가 발생했든 안했든 무조건 실행)
		System.out.println("B: after ");
	}

}
