package com.future;

import java.util.concurrent.Callable;

public class tesk implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		System.out.println("子线程开始实例化+++++++++++");
		Thread.sleep(3000);
		int sum=0;
		for(int i=0;i<100;i++){
			sum+=i;
		}
		return sum;
	}
}