package com.ssafy.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//설정 파일로 인식해 달라는 어노테이션
@Configuration
//한 번에 스캔하는 방식으로 하나씩 @Bean으로 등록하던 것을 대신함
@ComponentScan(basePackages= {"com.ssafy.di"})
public class ApplicationConfig2 {
	//자바 형식에서는 xml 파일은 필요 없지만, 대신 설정을 담아 둘 ApplicationConfig 파일이 필요. 
	
//	@Bean
//	public Desktop desktop() {
//		return new Desktop();
//	}
//	
//	@Bean
//	public Programmer programmer() {
//		//생성자 주입 방식
//		Programmer p = new Programmer(desktop());
//		return p;
//	}

}
