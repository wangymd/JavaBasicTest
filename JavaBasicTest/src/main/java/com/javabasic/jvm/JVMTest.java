package com.javabasic.jvm;

/**
 * jvm内存查看
 * @author wangym
 *
 */
public class JVMTest {

	public static void main(String[] args) {
		Runtime runtime = Runtime.getRuntime();
		//默认情况下，分配给JVM最大内存空间，总内存的1/4
		System.out.println("maxMemory=" + runtime.maxMemory() + "(" + runtime.maxMemory() / 1024 / 1024 +"M)");
		//默认情况下，除了伸缩去之外JVM可用内存空间
		System.out.println("totalMemory=" + runtime.totalMemory() + "(" + runtime.totalMemory() / 1024 / 1024 +"M)");
		System.out.println("freeMemory=" + runtime.freeMemory() + "(" + runtime.freeMemory() / 1024 / 1024 +"M)");
		
		System.out.println("freeMemory/maxMemory=" + (double)runtime.maxMemory() / runtime.totalMemory());
		
		System.out.println("伸缩区=" + (runtime.maxMemory() - runtime.totalMemory()) / 1024 / 1024 +"M");
	}

}
