package com.ssafy.di4_의존성주입;

import java.util.Scanner;

public class Test {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		
		Desktop desktop = new Desktop();
		Laptop laptop = new Laptop();
//		Programmer p = new Programmer(laptop);
		
		
		//프로그래머를 생성할 땐 컴퓨터 종류를 생성하지 않았다가, 이후에 set을 활용하여 프로그래머에 맞는 컴퓨터를 설정해 줌. 
		Programmer p2 = new Programmer();
		
		p2.setComputer(laptop);
		
//		p2.coding();
		//기존에는 실행하여 그 순간에 설정을 읽어와서 만들었으나,
		//실행 환경에서 그 때 필요한 조건으로 부품을 갈아끼움.
		Programmer p3 = new Programmer();
		while(true) {
			p3.setComputer(ComputerFactory.getComputer(sc.next()));
			p3.coding();
		}
	}

}
