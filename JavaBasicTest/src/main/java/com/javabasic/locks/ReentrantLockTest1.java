package com.javabasic.locks;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock
 * 
 * @author win7
 *
 */
public class ReentrantLockTest1 {

	public static void main(String[] args) {
		final ReentrantLock lock = new ReentrantLock(true);
		for (int i = 0; i < 100; i++) {
			String name = "T"+i;
			new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println("获取锁");
					lock.lock();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("释放锁");
					lock.unlock();
				}
			},name).start();
		}
		while(Thread.activeCount() > 2) {}
	}

}
