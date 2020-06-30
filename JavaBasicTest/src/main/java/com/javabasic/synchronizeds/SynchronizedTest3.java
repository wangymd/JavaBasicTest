package com.javabasic.synchronizeds;

/**
 * synchronized同步锁
 * 修饰实例方法、修饰静态方法、修饰代码块
 * 直接访问静态变量，结果为改变？？？TODO
 * 
 * @author win7
 */
public class SynchronizedTest3 {
	
	public static int THREAD_COUNT = 20;
	
	public static void main(String[] args) {
		final ShareData shareData = new ShareData();
		for (int i = 0; i < THREAD_COUNT; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < 10000; i++) shareData.increase2();
				}
			}).start();
		}
		//等待子线程执行完毕
		while (Thread.activeCount() > 1) Thread.yield();
		System.out.println(shareData.getNum());
	}

}
