package com.javabasic.thread.callable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTest3Main {

	public static void main(String[] args) {
		/**
		 * Executors:(java.util.concurrent)类提供了用于此包中所提供的执行程序服务的工厂方法
		 * 
		 * 创建一个可重用固定线程数的线程池，以共享的无界队列方式来运行这些线程。
		 */
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		CallableTest3 callableDemo1 = new CallableTest3("Callable1");
		CallableTest3 callableDemo2 = new CallableTest3("Callable2");
		try {
			//提交一个返回值的任务用于执行，返回一个表示任务的未决结果的 Future
			Future<Integer> future1 = executorService.submit(callableDemo1);
			long ts1 = System.currentTimeMillis();
			System.out.println(callableDemo1.getName() + "执行完毕" + future1.get());
			Future<Integer> future2 = executorService.submit(callableDemo2);
			Thread.sleep(5000);
			long ts2 = System.currentTimeMillis();
			System.out.println(callableDemo2.getName() + "执行完毕" + future2.get());
			System.out.println(ts2 - ts1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		executorService.shutdown();
	}
}
