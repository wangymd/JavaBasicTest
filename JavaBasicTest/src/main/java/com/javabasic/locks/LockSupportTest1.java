package com.javabasic.locks;

import java.util.concurrent.locks.LockSupport;

/**
 * LockSupport
 * @author win7
 *
 */
public class LockSupportTest1 {
	
	public static void main(String[] args) throws Exception {
		
		Thread childThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("child thread begin park!");
				//调用park方法，挂起自己
				LockSupport.park();
				System.out.println("child thread unpark!");
			}
		});
		childThread.start();
		
		Thread.sleep(1000);//休眠1s是为了让子线程输出："child thread unpark!"
		
		System.out.println(">>>>>>>child thread start unpark!");
		LockSupport.unpark(childThread);//
		System.out.println(">>>>>>>child thread end unpark!");
	}

}
