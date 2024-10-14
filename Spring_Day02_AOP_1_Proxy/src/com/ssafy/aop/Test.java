package com.ssafy.aop;

public class Test {
	public static void main(String[]args) {
		Programmer p= new Programmer();
		PersonProxy px = new PersonProxy(); //스프링이 알아서 해주는 것
		px.setPerson(p);
		px.coding();
	}

}
