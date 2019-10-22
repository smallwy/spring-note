package com.spring.autowired;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class aspects{
	@Pointcut(value = "execution(* com.test.autowired.service.*.*(..))")
	public void handleAspect(){
		System.out.println("执行切点----------------------");
	}

	@Before(value = "handleAspect()")
	public void printBefor(){
		System.out.println("----------执行aop操作----------");
	}
}