package com.jdk;

import java.util.concurrent.locks.ReentrantLock;

public class LockO {


	public static void main(String[] args) {


		//排他锁
		final ReentrantLock reentrantLock=new ReentrantLock(true);

		reentrantLock.lock();

		//AbstractQueuedSynchronizer 队列

	}
}