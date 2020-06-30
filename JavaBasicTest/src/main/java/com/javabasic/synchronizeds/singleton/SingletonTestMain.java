package com.javabasic.synchronizeds.singleton;

import java.util.HashSet;
import java.util.Set;

/**
 * 双重检验锁单例模式测试
 * @author win7
 *
 */
public class SingletonTestMain {
	
	public static int THREAD_COUNT = 20;

	public static void main(String[] args) {
		final Set<Singleton> instanceSet = new HashSet<Singleton>();
		for (int i = 0; i < THREAD_COUNT; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					instanceSet.add(Singleton.getUniqueInstance());
				}
			}).start();
		}
		//等待子线程执行完毕
		while (Thread.activeCount() > 1) Thread.yield();
		System.out.println(instanceSet.size());
		System.out.println(instanceSet);
	}

}
