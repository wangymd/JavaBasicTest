package com.javabasic.jvm.chapter12;

public class VolatileTest2 {
	
	private static final int THREADS_COUNT = 20;

	public static void main(String[] args) {
		VolatileTest2 volatileTest2 = new VolatileTest2();
		final Test test = volatileTest2.new Test();
		for (int i = 0; i < THREADS_COUNT; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					for (int j = 0; j < 1000; j++) {
						test.doTask();
						System.out.println(Thread.currentThread().getName() + "-" + j);
					}
					
				}
			},i+"").start();
		}

		while(Thread.activeCount() > 1) Thread.yield();
	}

	public class Test{
		public volatile Boolean isLock = true;

		public Boolean getIsLock() {
			return isLock;
		}

		public void setIsLock(Boolean isLock) {
			this.isLock = isLock;
		}
		
		public void doTask() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			isLock = false;
		}
	}
}

