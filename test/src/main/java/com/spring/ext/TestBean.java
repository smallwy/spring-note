package com.spring.ext;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class TestBean {

	@Autowired
	ApplicationContext applicationContext;

	public void query(){
		System.out.println("1111111111");

		this.applicationContext.publishEvent(new AventType(this,1,"注册一个RootBeanDefinition"));

	}
}