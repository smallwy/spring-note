package com.spring.autowired;

import org.springframework.stereotype.Component;

@Component("a")
public class Aservice {

	public void pringtSs(){
		System.out.println("执行注入对象的方法");
	}
}