package com.javabasic.locks;

import java.util.concurrent.locks.LockSupport;

/**
 * LockSupport
 * 如果调用线程之前没有调用park方法，则调用unpack方法后再调用park方法，会立刻返回；
 * 
 * @author win7
 *
 */
public class LockSupportTest0 {
	
	public static void main(String[] args) throws Exception {
		System.out.println("begin park!");
		
		//是当前线程获取许可证
		LockSupport.unpark(Thread.currentThread());
		
		//再次调用park
		LockSupport.park();
		
		while(Thread.activeCount() > 1) {}
		System.out.println("end park!");
	}

}
