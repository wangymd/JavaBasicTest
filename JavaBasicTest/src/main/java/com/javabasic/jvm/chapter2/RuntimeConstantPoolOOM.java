package com.javabasic.jvm.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 *  2-6 运行时常量池溢出
 *  -verbose:gc -XX:PermSize=10m -XX:MaxPermSize=10m
 * @author wangym
 *
 */
public class RuntimeConstantPoolOOM {

	public static void main(String[] args) {
		//使用list保持着常量池的引用，避免Full GC回收常量池行为
		List<String> list = new ArrayList<String>();
		int i = 0;
		while (true) {
			list.add(String.valueOf(i++).intern());
		}
	}

}
