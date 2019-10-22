package com.jdk.syn;

public class testThread {
	public static void main(String[] args) {
		addMethod add = new addMethod();
		for (int i = 0; i < 100; i++) {
	     		new Thread(() -> {
				int a = add.addIncre();
				System.out.println("a的值为" + a);
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}).start();
		}
	}
}