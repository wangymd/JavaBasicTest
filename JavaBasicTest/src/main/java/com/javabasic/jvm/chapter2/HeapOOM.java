package com.javabasic.jvm.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * 2-3	Java堆内存溢出异常测试
 * -java.lang.OutOfMemoryError: Java heap space
 * -verbose:gc -Xmx20m -Xms20m -XX:+HeapDumpOnOutOfMemoryError
 * @author wangym
 *
 */
public class HeapOOM {
	
	static class OOMObject{}

	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<OOMObject>();
		while(true) {
			list.add(new OOMObject());
		}
	}

}
