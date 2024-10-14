package com.ssafy.di1_의존성개념;

public class Test {
	public static void main(String[]args) {
		
		//프로그래머가 데스크톱에 대한 의존성을 가지고 있다. 
		//Class A 객체가 어떤 일을 처리하기 위해서 Class B의 객체의 도움을 받아야만 일을 처리할 수 있다면
		//'Class A는 ClassB에 의존한다'라고 함. 
		
		//프로그래머를 새로 생성할 때마다 컴퓨터를 하나 생성하게 됨.
		//즉, 컴퓨터 클래스는 프로그래머 클래스에 의존함. 
		Programmer p = new Programmer();
		p.coding();
	}

}
