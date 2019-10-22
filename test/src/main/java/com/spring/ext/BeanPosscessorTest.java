package com.spring.ext;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanPosscessorTest {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ExtConfig.class);
		TestBean testBean=(TestBean)applicationContext.getBean("tb1");
		testBean.query();
	}
}