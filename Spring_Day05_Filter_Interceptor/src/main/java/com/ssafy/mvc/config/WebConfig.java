package com.ssafy.mvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.mvc.interceptor.AInterceptor;
import com.ssafy.mvc.interceptor.BInterceptor;
import com.ssafy.mvc.interceptor.CInterceptor;
import com.ssafy.mvc.interceptor.LoginInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	//registry.addInterceptor()의 파라미터로 아까 @Component를 활용하여 bean으로 등록한 AInterceptor를 넣고 싶은데 어떻게 할까?
	// 지금 필요한 게 의존성 주입! (필드 주입, 생성자 주입, 설정자 주입)
	@Autowired
	private AInterceptor aInterceptor;
	
	@Autowired
	private BInterceptor bInterceptor;
	
	@Autowired
	private CInterceptor cInterceptor;
	
	@Autowired
	private LoginInterceptor loginInterceptor;
	
	
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(aInterceptor).addPathPatterns("/hello");
//		registry.addInterceptor(bInterceptor).addPathPatterns("/hello");
//		registry.addInterceptor(cInterceptor).addPathPatterns("/hello");
		registry.addInterceptor(loginInterceptor).addPathPatterns("/regist").excludePathPatterns("/hello");
		// -> 뜻 : regist가 호출되면 이 인터셉터를 작동시키고, /hello일 땐 이 인터셉터 하지말고 봐줘~. 사실 여기선 excludePathPatterns에 hello를 넣지않아도 hello에 접근이 가능함. 예시로 하는 겨~
		//예를 들어 addPathPatterns에 (/**)를 넣고, excludePathPatterns("/회원가입")을 넣으면 회원가입을 제외한 모든 페이지에 들어가지 못함. 
	}
	
	
	

}
