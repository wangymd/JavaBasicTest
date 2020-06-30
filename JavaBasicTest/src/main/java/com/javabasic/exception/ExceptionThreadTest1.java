package com.javabasic.exception;

/**
 * 线程执行异常
 * @author win7
 *
 */
public class ExceptionThreadTest1 implements Runnable{
	
	public void run() {
		int i = 1/0;
		System.out.println("TreadDemo1线程执行了!");
	}
}
