package com.javabasic.thread.callable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTest1Main {

	public static void main(String[] args) {
		/**
		 * Executors:(java.util.concurrent)类提供了用于此包中所提供的执行程序服务的工厂方法
		 * 
		 * 创建一个可重用固定线程数的线程池，以共享的无界队列方式来运行这些线程。
		 */
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		CallableTest1 callableDemo1 = new CallableTest1();
		callableDemo1.setStatus(true);
		//提交一个返回值的任务用于执行，返回一个表示任务的未决结果的 Future
		Future<String> future = executorService.submit(callableDemo1);
		try {
			System.out.println("执行完毕" + future.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		executorService.shutdown();
	}
}
