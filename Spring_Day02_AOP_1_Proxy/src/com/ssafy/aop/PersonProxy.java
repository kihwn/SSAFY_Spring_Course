package com.ssafy.aop;

import java.util.Random;

import com.ssafy.proxy.OuchException;

public class PersonProxy implements Person{
	//프록시 객체에 주입한 인간
	private Person person;
	//설정자 주입
	public void setPerson(Person person) {
		this.person = person;
	}
	
	@Override
	public void coding() {
		System.out.println("컴퓨터를 부팅한다. "); //이전에 수행해야 할 기능
		try {
		//System.out.println("열심히 코드를 작성한다. ");
			person.coding(); //핵심 관심사항
			if (new Random().nextBoolean())
				throw new OuchException();
			System.out.println("Git에 commit한다. ");} //핵심 관심 사항
			catch(OuchException e) {
				e.handleException();
				System.out.println("조퇴한다."); //비정상 마무리
			}finally {
				System.out.println("침대와 한 몸이 된다."); //모든 게 마무리
			}
	}

}
