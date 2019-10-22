package com.jdk.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class atomicTest {


	public static void main(String[] args) {

		AtomicInteger integer = new AtomicInteger();
		int a=	integer.getAndDecrement();
		System.out.println(a);

	}

}
