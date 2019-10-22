package com.spring.seivice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Handler implements InvocationHandler {
	Object o;

	public Handler(Object o) {
		this.o = o;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("aop------------------------");
		Object relust=method.invoke(o);
		System.out.println("after -----aop");
		return relust;

	}
}