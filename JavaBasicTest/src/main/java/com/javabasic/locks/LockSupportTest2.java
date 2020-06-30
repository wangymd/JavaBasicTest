package com.javabasic.locks;

import java.util.concurrent.locks.LockSupport;

/**
 * LockSupport
 * @author win7
 *
 */
public class LockSupportTest2 {
	
	public static void main(String[] args) throws Exception {
		
		Thread childThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("child thread begin park!");
				//只有被中断，才会停止循环 
				while(!Thread.currentThread().isInterrupted()) {
					//调用park方法，挂起自己
					LockSupport.park();
				}
//				LockSupport.park();
				System.out.println("child thread unpark!");
			}
		});
		childThread.start();
		
		Thread.sleep(1000);
		
		System.out.println("main thread begin unpark!");
		
//		LockSupport.unpark(childThread);
		childThread.interrupt();//中断子进程
	}

}
