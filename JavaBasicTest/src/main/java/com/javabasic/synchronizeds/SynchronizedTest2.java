package com.javabasic.synchronizeds;

/**
 * synchronized同步锁
 * 修饰实例方法、修饰静态方法、修饰代码块
 * 
 * @author win7
 */
public class SynchronizedTest2 {
	
	public static int THREAD_COUNT = 20;
	
	public static void main(String[] args) {
		final ShareData shareData = new ShareData();
		for (int i = 0; i < THREAD_COUNT; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < 10000; i++) shareData.increase1();
				}
			}).start();
		}
		//等待子线程执行完毕
		while (Thread.activeCount() > 1) Thread.yield();
		System.out.println(shareData.getNum());
	}

}
