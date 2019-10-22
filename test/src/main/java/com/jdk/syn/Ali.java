package com.jdk.syn;

import java.util.ArrayList;
import java.util.List;

public class Ali {

	static       int tickCount = 0;
	final static int MAX = 1000000;

	public static void main(String[] args) throws InterruptedException {

		List<Integer> sets=new ArrayList<>();
		new Thread(new Runnable() {
			@Override
			public void run() {
					while (tickCount <= MAX) {
						int tickCount=crwace();
						if(sets.contains(tickCount)){
							System.out.println("已经cunza9-------------------------------------------------------------------------------"+tickCount);
						}
						sets.add(tickCount);
					}
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
					while (tickCount <= MAX) {
						int tickCount=crwace();
						if(sets.contains(tickCount)){
							System.out.println("已经cunza9------------------------------------------------------------------------------------"+tickCount);
						}
						sets.add(tickCount);
					}
			}
		}).start();


		Thread.sleep(2000);
	}


	public static int  crwace(){
		return  tickCount++;

	}
}