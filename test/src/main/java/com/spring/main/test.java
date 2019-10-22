package com.spring.main;

import com.spring.app.Appconfig;
import com.spring.in.TestService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class test {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext 	applicationContext=	 new AnnotationConfigApplicationContext(Appconfig.class);
		//这里会报错 目标对象被代理了  啥时候代理的
		/*TestService testDao = (TestService) applicationContext.getBean("c");
		//如果testDao有代理对象 那么久执行代理对象的方法
		testDao.query();*/
		/*ConfigurableEnvironment ev = applicationContext.getEnvironment();*/
		/*System.out.println(applicationContext.getBean("rainbow"));
		String[] names=applicationContext.getBeanDefinitionNames();
		for(String name:names){
			System.out.println(name);
		}*/

		TestService testDao = (TestService) applicationContext.getBean("c");
		testDao.query();
	}
}