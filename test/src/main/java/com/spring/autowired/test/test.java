package com.spring.autowired.test;

import com.spring.autowired.config;
import com.spring.autowired.service.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class test{

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(config.class);
		/*TestService testService= (TestService) applicationContext.getBean("testService");
		System.out.println(testService);
		testService.testAop();*/
		Student student= (Student) applicationContext.getBean("factoryService");
		student.print();

	}
}