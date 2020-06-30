package com.javabasic.unsafe;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * Unsafe如何使用
 * 
 * 1、使用Unsafe.getUnsafe();获取对象会报错
 * Exception in thread "main" java.lang.ExceptionInInitializerError
Caused by: java.lang.SecurityException: Unsafe
	at sun.misc.Unsafe.getUnsafe(Unsafe.java:90)
	at com.javabasic.unsafe.UnsafeTest1.<clinit>(UnsafeTest1.java:13)
 * 2、插卡源码，只要通过反射获取成员变量theUnsafe即可
 * @author win7
 *
 */
public class UnsafeTest2 {
	
	//获取Unsafe实例对象
	static final Unsafe unsafe;
	
	//变量
	private volatile long state=0;
	
	//记录变量state在类UnsafeTest1中的偏移量
	static final long stateOffset;
	
	static {
		//获取state变量在类UnsafeTest1中的偏移值
		try {
			//使用反射获取Unsafe的成员变量theUnsafe
			Field field = Unsafe.class.getDeclaredField("theUnsafe");
			field.setAccessible(true);
			unsafe = (Unsafe)field.get(null);
			stateOffset = unsafe.objectFieldOffset(UnsafeTest2.class.getDeclaredField("state"));
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			throw new Error(e);
		}
	}
	
	public static void main(String[] args) {
		UnsafeTest2 unsafeTest1 = new UnsafeTest2();
		boolean compareAndSwapInt = unsafe.compareAndSwapInt(unsafeTest1, stateOffset, 0, 1);
		System.out.println(compareAndSwapInt);
	}

}
