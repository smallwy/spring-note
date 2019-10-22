package com.lock;

import sun.misc.Unsafe;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.LockSupport;

public class MyLock {
	public static volatile int state = 0;

	private static final Unsafe unsafe = Unsafe.getUnsafe();

	private static Queue queue=new LinkedBlockingQueue();

	public void lock() throws InterruptedException {
		//争取锁  没有成功则让出时间片
		while (!unsafe.compareAndSwapInt(this, 0L, 0, 1)) {
			addPark();
		}
		//争取成功
		state=1;
		System.out.println("执行对应的业务"+Thread.currentThread().getName());
		Thread.sleep(5000);
		unPark();
	}

	private void unPark() {
		state=0;
		queue.poll();
	}

	private void addPark() {
		LockSupport.park();
		queue.offer(Thread.currentThread());
	}
}