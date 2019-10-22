package com.spring.seivice;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringHolder implements ApplicationContextAware {

	private static   ApplicationContext context;


	public SpringHolder() {
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context=applicationContext;

	}


	public static <T> T getBean(Class<T> clazz) {
		return context.getBean(clazz);
	}

}