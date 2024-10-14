package com.ssafy.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test2 {
	public static void main(String[]args) {
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext2.xml");
		
		Programmer p = context.getBean("programmer",Programmer.class);
		
		p.coding();
	}

}

//1.테이블 만들기
//2. CRUD (전체 조회 / 원하는 부분만 조회)
//3. 서술형 문제.