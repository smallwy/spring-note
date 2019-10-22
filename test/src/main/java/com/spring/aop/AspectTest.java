package com.spring.aop;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectTest {

	@Pointcut(value = "execution(* com.test.in.*.*(..))")
	public void runPrint(){
		System.out.println("执行切点----------------------");
	}

	/*@Pointcut(value = "@within(com.test.aop.stone)")
	public void runPrint(){
		System.out.println("执行切点----------------------");
	}
*/
	/*@Pointcut(value = "within(com.test.dao.*)")
	public void runPrint(){
		System.out.println("执行切点----------------------");
	}*/


	/*@Pointcut(value = "this(com.test.dao.TestDao)")
	public void runPrint(){
		System.out.println("执行切点----------------------");
	}*/


/*	@Pointcut(value = "this(com.test.seivice.L)")
	public void runPrint(){
		System.out.println("执行切点----------------------");
	}*/


/*
	@Pointcut(value = "target(com.test.seivice.L)")
	public void runPrint(){
		System.out.println("执行切点----------------------");
	}
*/


	@After("runPrint()")
	public void afterPrint(){
		System.out.println("执行after切点----------------------");
	}

	@Before("runPrint()")
	public void beforPrint(){
		System.out.println("执行befor切点----------------------");
	}

}