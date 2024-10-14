package com.ssafy.di;

import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
public class Test {
	public static void main(String[]args) {
		//괄호 안에는 경로
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig2.class);
		
		
		Programmer p = context.getBean("p",Programmer.class);
		p.coding();
	}

}

