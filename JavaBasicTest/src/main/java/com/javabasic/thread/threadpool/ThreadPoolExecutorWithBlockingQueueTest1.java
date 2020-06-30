package com.javabasic.thread.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池+阻塞队列
 * @author win7
 *
 */
public class ThreadPoolExecutorWithBlockingQueueTest1 {

	public static void main(String[] args) {
		BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<Runnable>(10);
		
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(6, 10, 5000, TimeUnit.HOURS, blockingQueue);
		threadPoolExecutor.prestartAllCoreThreads();
		threadPoolExecutor.execute(new Runnable() {
			public void run() {
				System.out.println("线程执行了。。。");
				
			}
		});
		
		System.out.println("线程池任务数量：" + threadPoolExecutor.getTaskCount());
		threadPoolExecutor.shutdown();
	}
}
