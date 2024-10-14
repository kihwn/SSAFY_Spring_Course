package com.ssafy.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//설정 파일로 인식해 달라는 어노테이션
@Configuration
public class ApplicationConfig {
	//자바 형식에서는 xml 파일은 필요 없지만, 대신 설정을 담아 둘 ApplicationConfig 파일이 필요. 
	
	@Bean
	public Desktop desktop() {
		return new Desktop();
		//new라고 쓰여있어도 새롭게 생성되는 것이 아니라 초기에 싱글턴으로 생성된 것을 보내주는 것. 
	}
	
	@Bean
	public Programmer programmer() {
		//생성자 주입 방식
		Programmer p = new Programmer(desktop());
		return p;
	}

}

