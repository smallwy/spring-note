package com.thread;

public class DeadLock {
	private static Object lock1 = new Object();
	private static Object lock2 = new Object();

	public static void main(String[] args) {
/*		new Thread(()->{
			synchronized (lock1){
				try {
					System.out.println("thread start1");
					Thread.sleep(5000);
				}catch (InterruptedException e){
					e.printStackTrace();
				}
				synchronized (lock2){
					System.out.println("thread2 start");
				}
			}
		}).start();

		new Thread(()->{
			synchronized (lock2){
				try {
					System.out.println("thread start2");
					Thread.sleep(5000);
				}catch (InterruptedException e){
					e.printStackTrace();
				}
				synchronized (lock1){
					System.out.println("thread2 star1");
				}
			}
		}).start();*/

	/*	//匿名内部类
		new Thread(){
			@Override
			public void run() {
				super.run();
			}
		}.start();*/
		//匿名内部类
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("父类");
			}
		}){
			//多态的原理
			public void run() {
				System.out.println("子类");
			}
		}.start();
	}
}