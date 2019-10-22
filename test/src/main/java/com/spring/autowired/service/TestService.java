package com.spring.autowired.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component("testService")
@Lazy(true)
public class TestService {

	@Autowired
	UserService1 userService;

	public TestService() {
		System.out.println("TestService---------------无参构造器创建对象");
	}

	//bean创建完好后的回调
	@PostConstruct
	public void after(){
		System.out.println("TestService------------------bean初始化完后的回调");
	}

	public void  testAop(){
		System.out.println("++++++++++++正在执行TestService方法++++++++++");
	}
}