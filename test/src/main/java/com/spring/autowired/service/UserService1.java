package com.spring.autowired.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component("userService")
public class UserService1 {

	//UserService 里面需要testService
	@Autowired
	@Lazy(true)
	TestService testService;

	public UserService1() {
		System.out.println("UserService---------------无参构造器创建对象");
	}

	@PostConstruct
	public void after(){
		System.out.println("UserService------------------bean初始化完后的回调");
	}
}