package com.javabasic.jvm.chapter2;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * 2-9 使用unsafe分配本机内存
 * -verbose:gc -Xmx20m -XX:MaxDirectMemorySize=10M
 * @author wangym
 *
 */
public class DirectMemoryOOM {
	
	private static final int _1MB = 1024 * 1024;
	
	public static void main(String[] args) throws Exception{
		Field unsafeField = Unsafe.class.getDeclaredFields()[0];
		unsafeField.setAccessible(true);
		Unsafe unsafe = (Unsafe)unsafeField.get(null);
		while (true) {
			unsafe.allocateMemory(_1MB);
		}
	}

}
