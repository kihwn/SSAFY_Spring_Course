package com.ssafy.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value="p")
public class Programmer {
	private Computer computer;
	
	public Programmer() {}
	
	//생성자 주입. 생성자를 하나만 정의하면 @Autowired를 직접 입력하지 않아도 자동으로 붙어있음.
	public Programmer(Computer computer) {
		//가지고 있는 데스크탑 한 개 줘!
		this.computer = computer;
	}
	
	//설정자를 이용해서 주입. @component를 laptop과 desktop 모두에 걸어놓으면
	//p가 알아서 찾아가지 못함. 따라서 @Qualifier을 걸어줘야 함. 
	@Autowired
	@Qualifier("laptop")
	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	
	//메서드를 통해서 주입을 할 수도 있음
	
	
	public void coding() {
		System.out.println(computer.getInfo()+"으로 개발을 합니다.");
	}

	
}
