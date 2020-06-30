package com.javabasic.threadlocal;

public class ThreadLocalTest1 {

	private static int nextSerialNum = 0;

	private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
		protected synchronized Integer initialValue() {
			return new Integer(nextSerialNum ++);
		}
	};

	public static int getThreadNum() {
		return threadLocal.get().intValue();
	}
}
