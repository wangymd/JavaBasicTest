package com.javabasic.jvm;

import java.util.Random;

/**
 * 堆内存溢出
 * java.lang.OutOfMemoryError
 * -verbose:gc -Xmx10m -Xms10m -XX:+PrintGCTimeStamps
 * @author wangym
 *
 */
public class OOMTest {

	public static void main(String[] args) {
		String str = "hello world";
		Random random = new Random();
		while(true) {
			str = str + random.nextInt(999999999);
			str.intern();//入池，强制性生成垃圾
		}
	}

}
