package com.javabasic.threadlocal;

public class ThreadLocalTest1Main {

	public static void main(String[] args) {
		int threadNum = ThreadLocalTest1.getThreadNum();
		System.out.println(threadNum);
		
		for (int j = 0; j < 10; j++) {
			Thread thread = new Thread(new Runnable() {
				public void run() {
					int threadNum2 = ThreadLocalTest1.getThreadNum();
					System.out.println(threadNum2);
				}
			}, "newThread" + j);
			
			thread.start();
		}
		
		while (Thread.activeCount() > 1) {
			Thread.yield();
		}
		System.out.println("子线程执行完成！");
	}
}
