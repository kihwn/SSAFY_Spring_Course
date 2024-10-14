package com.ssafy.di;

import org.springframework.stereotype.Component;

@Component
public class Desktop implements Computer {
	//멤버필드 작성
	//private String CPU
	//private String RAM;
	
	//...작성을 할 수 있다. 오늘은 안함. 
	
	public Desktop() {
		System.out.println("생성이 완료");
	}
	
	public String getInfo() {
		return "데스크톱";
	}

}
