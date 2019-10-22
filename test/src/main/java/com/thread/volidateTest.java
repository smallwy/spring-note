package com.thread;


//B线程等待A线程执行完任务

// volatile使处理器缓存行的数据写会到系统内存
// 这个写回的操作回使其他Cpu缓存该内存地址的数据失效
public class volidateTest{
	public   volatile boolean flag=false;

	public static void main(String[] args) throws InterruptedException {

		volidateTest demo=new volidateTest();
		new Thread(new Runnable() {
			public void run() {
				for(int i=0;i<10;i++) {
					System.out.println("A线程执行完毕-----------"+i);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				demo.flag=true;
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				//前期是一个死循环  直到flag改变  才往后执行
				while(!demo.flag) {
				}
				System.out.println("B线程开始执行");
			}
		}).start();
	}
}