package com.javabasic.thread.test01;

/**
 * 线程启动：start和run的区别
 * @author win7
 *
 */
public class ThreadMainTest1 {

	public static void main(String[] args) {
		new ThreadTest1().run();//仅仅是调用方法
		new ThreadTest1().start();//创建和启动线程
	}
}
