package com.ssafy.aop;

import java.util.Random;

public class Ssafy implements Person {
	public int coding() {
		System.out.println("열심히 공부를 한다."); //핵심 관심 사항 
		
		if (new Random().nextBoolean()) {
			throw new OuchException();
		}
		return (int)(Math.random()*10)+1; 
}


}
