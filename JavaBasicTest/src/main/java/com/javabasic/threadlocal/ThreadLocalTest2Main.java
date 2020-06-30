package com.javabasic.threadlocal;

public class ThreadLocalTest2Main {

	public static void main(String[] args) {
		ThreadLocalTest2 threadLocalManager = ThreadLocalTest2.getThreadLocalManager();
		threadLocalManager.setUserid("main");
		threadLocalManager.setPassword("main");
		System.out.println(ThreadLocalTest2.getThreadNum() + ":" + threadLocalManager.getUserid() + ":" + threadLocalManager.getPassword());
		
		for (int j = 0; j < 10; j++) {
			Thread thread = new Thread(new Runnable() {
				
				public void run() {
					//模拟线程停顿
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					ThreadLocalTest2 innerThreadLocalManager = ThreadLocalTest2.getThreadLocalManager();
					innerThreadLocalManager.setUserid(Thread.currentThread().getName());
					innerThreadLocalManager.setPassword(Thread.currentThread().getName());
					System.out.println(ThreadLocalTest2.getThreadNum() + ":" + innerThreadLocalManager.getUserid() + ":" + innerThreadLocalManager.getPassword());
					
				}
			}, "newThread" + j);
			
			thread.start();
		}
		
		while(Thread.activeCount() > 1){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("当前启动的线程数量：" + Thread.activeCount());
			Thread.yield();
		}
		
		System.out.println("主线程执行完毕！");
		
	}
}
