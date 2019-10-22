package com.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Consumer;

public class test {
	public static void main(String[] args) {

		ExecutorService executorService = Executors.newCachedThreadPool();
		tesk task = new tesk();
		Future future = executorService.submit(task);
		executorService.shutdown();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		System.out.println("主线程在执行任务");

		try {
			System.out.println("task运行结果" + future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println("所有任务执行完毕");

		Consumer<String> consumer1 = (x) -> System.out.print(x);
		Consumer<String> consumer2 = (x) -> {
			System.out.println(" after consumer 1");
		};
		consumer1.andThen(consumer2).accept("test consumer1");
	}
}