package com.ssafy.di1_의존성개념;

public class Programmer {
	private Desktop desktop;
	
	public Programmer() {
		//프로그래머를 한 명 고용했다면 무조건 컴퓨터를 한 대 새로 사줌. 
		this.desktop = new Desktop();
	}
	
	public void coding() {
		System.out.println(desktop.getInfo()+"으로 개발을 합니다. ");
	}

	
}
