package com.javabasic.unsafe;

import sun.misc.Unsafe;

/**
 * Unsafe如何使用
 * 
 * Exception in thread "main" java.lang.ExceptionInInitializerError
Caused by: java.lang.SecurityException: Unsafe
	at sun.misc.Unsafe.getUnsafe(Unsafe.java:90)
	at com.javabasic.unsafe.UnsafeTest1.<clinit>(UnsafeTest1.java:13)
 * 
 * @author win7
 *
 */
public class UnsafeTest1 {
	
	//获取Unsafe实例对象
	static final Unsafe unsafe = Unsafe.getUnsafe();
	
	//变量
	private volatile long state=0;
	
	//记录变量state在类UnsafeTest1中的偏移量
	static final long stateOffset;
	
	static {
		//获取state变量在类UnsafeTest1中的偏移值
		try {
			stateOffset = unsafe.objectFieldOffset(UnsafeTest1.class.getDeclaredField("state"));
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			throw new Error(e);
		}
	}
	
	public static void main(String[] args) {
		UnsafeTest1 unsafeTest1 = new UnsafeTest1();
		boolean compareAndSwapInt = unsafe.compareAndSwapInt(unsafeTest1, stateOffset, 0, 1);
		System.out.println(compareAndSwapInt);
	}

}
