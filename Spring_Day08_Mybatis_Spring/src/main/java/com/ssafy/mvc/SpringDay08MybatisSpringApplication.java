package com.ssafy.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDay08MybatisSpringApplication {

	public static void main(String[] args) {
		ApplicationContext = SpringApplication.run(SpringDay08MybatisSpringApplication.class, args);
		for (String name: context.getBeanDefinitionNames())
			System.out.println(name);
	}

}
