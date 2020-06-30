package com.javabasic.thread.test;
/**
 * 线程实现的第二种方式
 * @author wangymd
 *
 */
public class ThreadTest2 extends Thread {

	public static void main(String[] args) {
		new ThreadTest2().start();
	}

	/**
	 * 重写run方法
	 */
	@Override
	public void run() {
		System.out.println("薛佳");
	}

}
