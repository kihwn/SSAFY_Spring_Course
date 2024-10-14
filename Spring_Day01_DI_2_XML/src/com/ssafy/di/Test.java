package com.ssafy.di;

import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
public class Test {
	public static void main(String[]args) {
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		//container가 빌드할 때 데스크탑 생성 후 getBean일 때 가지고 있는 것을 주는 것. 
		System.out.println("1");
		Programmer p = context.getBean("programmer",Programmer.class);
		Desktop d =(Desktop) context.getBean("desktop");
		
		
		
		p.setComputer(d);
		System.out.println("2");
		p.coding();
		
		Desktop d2 = context.getBean("desktop",Desktop.class);
		System.out.println(d==d2);
		//getBean을 사용할 때마다 desktop이 새로 생성되는 것이 아니라 싱글턴으로 관리됨.
	
	}

}

