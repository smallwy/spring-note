package com.thread;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.*;

/*创建线程的方式
 * 实现Runnable接口
 * 继承Thread类
 * 匿名内部类
 * 带返回值的 Callable
 * 定时器
 * 线程池
 * spring线程
 * */
public class ThreadCreate {


	public static void main(String[] args) throws ExecutionException, InterruptedException {

		/*Thread1 thread1 = new Thread1();
		Thread th1 = new Thread(thread1);
		th1.start();

		Thread2 thread2 = new Thread2();
		Thread th2 = new Thread(thread2);
		th2.start();

		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		th1.setDaemon(true);
		System.out.println("th1的运行状态为" + th1.isInterrupted());
		System.out.println("th1的运行状态为" + th1.isAlive());

		Thread3 thread3=new Thread3();
		thread3.start();

		//匿名内部类
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					System.out.println("匿名线程正在执行" + Thread.currentThread().getName());
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();*/

		//带返回值
/*		callBack back=new callBack();
		FutureTask futureTask=new FutureTask(back);
		futureTask.get();
		Thread thread=new Thread(futureTask);
		thread.start();
		System.out.println("线程执行完的结果为"+futureTask.get());*/

		//定时器
	/*	Timer timer=new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("timeTask is run");
			}o
		},0,1); //没有延迟  每隔1秒执行*/
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					System.out.println("匿名线程正在执行" + Thread.currentThread().getName());
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

		//线程池
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 100; i++) {
			Future future=	executorService.submit(new Runnable() {
				@Override
				public void run() {
					System.out.println("线程池的线程任务" + Thread.currentThread().getName());
				}
			});
			System.out.println(future.get());
		}
		executorService.shutdown();
	}
}

//实现Runnable接口
class Thread1 implements Runnable {

	@Override
	public void run() {
		System.out.println("Thread1正在执行" + Thread.currentThread().getName());
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Thread2 implements Runnable {

	@Override
	public void run() {
		while (true) {
			System.out.println("Thread2正在执行" + Thread.currentThread().getName());
			try {
				Thread.sleep(300);
				break;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

// 继承Thread
class Thread3 extends Thread {
	@Override
	public void run() {
		while (true) {
			System.out.println("Thread3正在执行" + Thread.currentThread().getName());
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

//带返回值的
class callBack implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		return 1024;
	}
}


//定时器的实现见上面
//spring定时器

class springTask {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(config.class);
		DemoService demoService=applicationContext.getBean(DemoService.class);
		demoService.a();
		demoService.b();
	}

	@Scheduled(cron = "fixedRate = 3000")
	public  void  excete(){
		System.out.println("执行定时器");
	}
}

