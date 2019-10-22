package com.jdk.syn;

public class IncreamDemo {

	public volatile static int m = 0;

	public synchronized static void add() {
		m++;
	}

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 100; i++) {
			new Thread(() -> {
				for (int j = 0; j < 50; j++) {
					IncreamDemo.add();
					System.out.println("m的值是" + m);
				}
			}).start();
		}
		Thread.sleep(200);
	}
}