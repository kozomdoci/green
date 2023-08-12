package com.lgy.spring_10_1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

// 공통기능 클래스
@Aspect
public class LogAop {

	// 공통기능의 적용범위 설정
	@Pointcut("within(com.lgy.spring_10_1.*)")
	private void pointCutMethod() {}
	
	// 공통기능의 실행시점 설정
	@Around("pointCutMethod()")
	public Object loggerAop(ProceedingJoinPoint joinPoint) throws Throwable {
		String signatureStr = joinPoint.getSignature().toShortString();
		System.out.println(signatureStr+" is started");
		long st = System.currentTimeMillis();
		Object obj = null;
		
		try {
			obj = joinPoint.proceed();
		} finally {
			long et = System.currentTimeMillis();
			System.out.println(signatureStr+" is finished");
			System.out.println(signatureStr+"의 경과시간 : "+(et-st));
		}
		return obj;
	}
}








