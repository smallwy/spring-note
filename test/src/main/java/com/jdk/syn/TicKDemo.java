package com.jdk.syn;

public class TicKDemo extends Thread {
	private static int tickCount = 0;
	private final static int MAX = 50;

	@Override
	public void run() {
		synchronized (this) {
			while (tickCount <= MAX) {
				System.out.println(Thread.currentThread().getName() + "输出的结果为" + tickCount++);
			}
		}
	}


	public static void main(String[] args) {
		TicKDemo ticKDemo1 = new TicKDemo();
		TicKDemo ticKDemo2 = new TicKDemo();
		TicKDemo ticKDemo3 = new TicKDemo();
		TicKDemo ticKDemo4 = new TicKDemo();
		ticKDemo1.start();
		ticKDemo2.start();
		ticKDemo3.start();
		ticKDemo4.start();
	}
}