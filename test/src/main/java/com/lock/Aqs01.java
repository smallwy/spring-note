package com.lock;

import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

public class Aqs01 {

	//公平锁
	@Test
	public void testFair() {
		ReentrantLock reentrantLock=new ReentrantLock();
		reentrantLock.lock();

	}
}