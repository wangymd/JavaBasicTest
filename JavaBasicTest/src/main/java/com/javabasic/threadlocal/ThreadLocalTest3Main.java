package com.javabasic.threadlocal;

public class ThreadLocalTest3Main {

	public static void main(String[] args) {
		ThreadLocalTest3 threadLocalManager = new ThreadLocalTest3();
		threadLocalManager.setAttibute("thread", "main");
		System.out.println(ThreadLocalTest3.getThreadNum() + ":" + threadLocalManager.getAttibute("thread"));
		threadLocalManager.removeAttibute("thread");
		System.out.println(ThreadLocalTest3.getThreadNum() + ":" + threadLocalManager.getAttibute("thread"));
		for (int j = 0; j < 3; j++) {
			Thread thread = new Thread(new Runnable() {
				
				public void run() {
					ThreadLocalTest3 innerThreadLocalManager = new ThreadLocalTest3();
					innerThreadLocalManager.setAttibute("thread", Thread.currentThread().getName());
					System.out.println(ThreadLocalTest3.getThreadNum() + ":" + innerThreadLocalManager.getAttibute("thread"));
					
					System.out.println(innerThreadLocalManager.toString());
					
				}
			}, "newThread" + j);
			
			thread.start();
		}
		
		while(Thread.activeCount() > 1){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("当前启动的线程数量：" + Thread.activeCount());
			Thread.yield();
		}
		
		System.out.println("主线程执行完毕！");
		
	}
}
