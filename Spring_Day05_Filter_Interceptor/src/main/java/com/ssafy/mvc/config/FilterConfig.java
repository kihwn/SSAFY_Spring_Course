package com.ssafy.mvc.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ssafy.mvc.filter.MyFilter1;
import com.ssafy.mvc.filter.MyFilter2;


//이 파일은 설정 파일이야. 
@Configuration
public class FilterConfig {
	@Bean
	public FilterRegistrationBean<MyFilter1> myfilter1(){ //메서드 명은 등록하려는 빈의 이름이 됨. 
		FilterRegistrationBean<MyFilter1>registrationBean = new FilterRegistrationBean<>(); //기본 생성자
		
		registrationBean.setFilter(new MyFilter1()); //어떤 필터를 . 
		registrationBean.addUrlPatterns("/hello"); // "/hello"라는 요청이 들어오면 이 필터를 작동시킴 //어떤 경로로
		registrationBean.setOrder(1); //어떤 순서로 ..
		return registrationBean;
		
	}
	
	
	@Bean
	public FilterRegistrationBean<MyFilter2> myfilter2(){ //메서드 명은 등록하려는 빈의 이름이 됨. 
		FilterRegistrationBean<MyFilter2>registrationBean = new FilterRegistrationBean<>(); //기본 생성자
		
		registrationBean.setFilter(new MyFilter2()); //어떤 필터를 . 
		registrationBean.addUrlPatterns("/hello"); // "/hello"라는 요청이 들어오면 이 필터를 작동시킴 //어떤 경로로
		registrationBean.setOrder(2); //어떤 순서로 ..
		return registrationBean;
		
	}

}
