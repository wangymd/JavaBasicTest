package com.javabasic.thread.test;

import java.util.concurrent.FutureTask;

import com.javabasic.thread.test.ThreadTest3;

public class ThreadTest3Main {
	
	public static void main(String[] args) {
		ThreadTest3 thread = new ThreadTest3();
		
//		try {
//			thread.call();
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println(e.getMessage());
//		}
		
		FutureTask<String> oneTask = new FutureTask<String>(thread);
		Thread newthread = new Thread(oneTask);
		newthread.start();
	}

}
