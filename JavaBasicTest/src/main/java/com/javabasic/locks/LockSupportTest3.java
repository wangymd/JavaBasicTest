package com.javabasic.locks;

import java.util.concurrent.locks.LockSupport;

/**
 * LockSupport
 * @author win7
 *
 */
public class LockSupportTest3 {
	
	public void park() {
		System.out.println("调用parkNanos方法：");
		LockSupport.parkNanos(2000000000);
//		LockSupport.park();
//		LockSupport.park(this);//阻塞挂起
	}
	
	public static void main(String[] args) throws Exception {
		LockSupportTest3 test3 = new LockSupportTest3();
		System.out.println("开始调用parkNanos方法：");
		test3.park();
	}

}
