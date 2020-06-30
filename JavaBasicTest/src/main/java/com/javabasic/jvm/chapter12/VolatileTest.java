package com.javabasic.jvm.chapter12;

/**
 * 12-1 volatile的运算
 * 下面参数没有成功
 * -verbose:gc -XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly 输出反汇编
 * 作用：1、变量的可见性；2、防止指令重排序
 * @author win7
 *
 */
public class VolatileTest {
	
	private static final int THREADS_COUNT = 20;
	
	public static volatile int race = 0;
	
	public static void increase() {
		race++;
	}

	public static void main(String[] args) {
		for (int i = 0; i < THREADS_COUNT; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					for (int j = 0; j < 1000; j++) {
						increase();
					}
				}
			}).start();
		}

		while(Thread.activeCount() > 1) Thread.yield();
		System.out.println(race);
	}

}
