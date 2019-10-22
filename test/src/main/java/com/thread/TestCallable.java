package com.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCallable implements Callable<Integer> {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		TestCallable testCallable=new TestCallable();
		FutureTask task=new FutureTask(testCallable);
		Thread thread=new Thread(task);
		thread.start();
		int rresult= (int) task.get();
		System.out.println(rresult);
	}

	@Override
	public Integer call() throws Exception {
		System.out.println("进行计算");
		return 1200;
	}
}