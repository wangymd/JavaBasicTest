package com.javabasic.thread.test;
/**
 * 线程实现的第一种方式
 * @author wangymd
 *
 */
public class ThreadTest1 extends Thread implements Runnable{

	public static void main(String[] args) {
		new ThreadTest1().start();
	}

	@Override
	public void run() {
		System.out.println("薛佳");
	}
	
}
