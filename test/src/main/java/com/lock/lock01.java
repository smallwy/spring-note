package com.lock;

//偏向锁 适用于只用一个线程访问同步代码块
public class lock01 {


	public static void main(String[] args) {

		lock01 lock01 = new lock01();
		//重入锁
		new Thread(new Runnable() {
			@Override
			public void run() {
				lock01.a();
			}
		}).start();
		
		//自旋
	}

	//重入锁 两个方法 都是使用同一个锁 synchronized和lock都可是重入锁
	public synchronized void a() {
		System.out.println("a");
		b();
	}

	public synchronized void b() {
		System.out.println("b");
	}


}