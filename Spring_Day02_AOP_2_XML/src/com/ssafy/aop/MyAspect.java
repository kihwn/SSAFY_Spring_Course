package com.ssafy.aop;

import org.aspectj.lang.ProceedingJoinPoint;

//공통 관심사항을 한 방에 저장할 클래스 (단위)
public class MyAspect {

	//메서드 명은 중요하지 않음
	public void before() {
		System.out.println("컴퓨터를 부팅한다.");
	}
	
	public void afterReturning(int num) {
		System.out.println("Git에 commit한다."+num+"줄을(시간을)");
	}
	
	public void afterThrowing(Throwable th) {
		System.out.println("조퇴를 한다.");
		if (th instanceof OuchException) {
			((OuchException)th).handleException();
		}
	}
	
	public void after() {
		System.out.println("침대와 한 몸이 된다.");
	}
	
	// 핵심 관심 사항이 실행 됐을 때의 시점을 가져올 것. 세세하게 하나하나 before after로 나눠서 할 수도 있지만,
	//around로 한 방에 묶을 수도 있음. 
	public int around(ProceedingJoinPoint pjt) {
		int num=0;
		
		this.before();
		try {
			num = (int)pjt.proceed();
			this.afterReturning(num);
		}catch(Throwable e) {
			this.afterThrowing(e);
		}finally {
			this.after();
		}
		return num;
	}
	
}
