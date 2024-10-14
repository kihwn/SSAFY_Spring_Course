package com.ssafy.di3_타입의존성제거;

public class Programmer {
	private Computer computer;
	
	public Programmer(Computer computer) {
		//가지고 있는 데스크탑 한 개 줘!
		this.computer = computer;
	}
	
	public void coding() {
		System.out.println(computer.getInfo()+"으로 개발을 합니다.");
	}

	
}
