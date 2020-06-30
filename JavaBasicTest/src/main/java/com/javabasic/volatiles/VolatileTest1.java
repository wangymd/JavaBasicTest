package com.javabasic.volatiles;

/**
 * volatile多线程操作共享变量
 * volatile特性：
 * 1、线程可见性
 * 2、禁止指令重排
 * @author win7
 *
 */
public class VolatileTest1 {
	
	private static volatile int var ;
	
	private static final int THREAD_COUNT = 20;

	public static void main(String[] args) {
		for(int i = 0 ;i < THREAD_COUNT ; i++){
			new Thread(new Runnable() {
				
				public void run() {
					for (int j = 0; j < 10000; j++) {
						increase();					
					}
				}
			}).start();
		}
		
		while(Thread.activeCount() > 1){
			System.out.println("当前线程数：" + Thread.activeCount());
			Thread.yield();
		}
		
		System.out.println(var);
		
	}
	//synchronized
	public static void increase(){
		var++;
	}
}
