package com.ssafy.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDay09DynamicQueryApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDay09DynamicQueryApplication.class, args);
//		for (String name : context.getBeanDefinitionNames())
//			System.out.println(name);
	}
}























