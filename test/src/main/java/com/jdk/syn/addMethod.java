package com.jdk.syn;

public class addMethod {
	 static  int  a = 0;

	public synchronized int addIncre() {
		a++;
		return a;
	}
}