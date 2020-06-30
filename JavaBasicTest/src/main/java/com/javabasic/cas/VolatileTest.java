package com.javabasic.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * JUC包下CAS机制：sun.misc.Unsafe
 * @author win7
 *
 */
public class VolatileTest {

	private static final int THREADS_COUNT = 20;

//	public static volatile int race = 0;
	public static AtomicInteger race = new AtomicInteger(0);

	public static void increase() {
//		race++;// 非原子操作
		race.getAndIncrement();// 原子操作
	}

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < THREADS_COUNT; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < 10000; i++) {
						increase();
					}
				}
			}).start();
		}

		while (Thread.activeCount() > 1) {
			Thread.yield();
		}
		System.out.println(race);
	}
}