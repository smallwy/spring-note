package com.spring.autowired;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component("b")
public class Bservice {

/*	@Autowired//默认使用ByType 如果根据类型没有找到就通过
	*//*@Resource(name = "")//默认使用ByName*//*
	Aservice aservice;

	public Bservice(Aservice aservice) {
		this.aservice = aservice;
	}*/

	@Lookup
	public Aservice getAservice() {
		return null;
	}


	public void print() {
		getAservice().pringtSs();
	}


}