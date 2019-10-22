package com.spring.autowired;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class xmlTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("game.xml");
		Bservice aservice= (Bservice) applicationContext.getBean("b");
		System.out.println(aservice);

		Bservice aservice1= (Bservice) applicationContext.getBean("b");
		System.out.println(aservice1);
	}
}