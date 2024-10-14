package com.ssafy.di2_객체생성의존성제거;

public class Programmer {
	private Desktop computer;
	
	public Programmer(Desktop desktop) {
		//가지고 있는 데스크탑 한 개 줘!
		computer = desktop;
	}
	
	public void coding() {
		System.out.println(computer.getInfo()+"으로 개발을 합니다. ");
	}

	
}
