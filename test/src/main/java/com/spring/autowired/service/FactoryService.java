package com.spring.autowired.service;

import org.springframework.beans.factory.FactoryBean;

public class FactoryService implements FactoryBean<Student> {
	@Override
	public Student getObject() throws Exception {
		Student student=new Student();
		return student;
	}

	@Override
	public Class<?> getObjectType() {
		return null;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}


}