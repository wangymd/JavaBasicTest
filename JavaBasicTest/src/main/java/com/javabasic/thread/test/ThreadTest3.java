package com.javabasic.thread.test;

import java.util.concurrent.Callable;

/**
 * 线程实现的第三种方式
 */
public class ThreadTest3 implements Callable<String> {
	
	private String clazz;
	
	public ThreadTest3() {
		
	}
	
	public ThreadTest3(String clazz) {
		
	}

	public String call() throws Exception {
		System.out.println("薛佳");
//		int i = 1/0;
//		User user = new User("wym", 18);
//		return user;
		return "Hello Callable thread !";
	}

}
