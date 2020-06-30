package com.javabasic.synchronizeds;

/**
 * synchronized同步锁
 * 修饰静态方法、修饰实例方法、修饰代码块
 * 不要使用 synchronized(String a)，因为JVM中字符串常量池具有缓存功能！
 * 
 * @author win7
 */
public class SynchronizedTest1 {
	
	public static int num = 0;
	
	public static int THREAD_COUNT = 20;
	
	//修饰实例方法：作用synchronizedTest1对象
	public synchronized static void increase() {
		num++;
	}

	public static void main(String[] args) {
		for (int i = 0; i < THREAD_COUNT; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < 10000; i++) increase();
				}
			}).start();
		}
		//等待子线程执行完毕
		while (Thread.activeCount() > 1) Thread.yield();
		System.out.println(num);
	}

}
