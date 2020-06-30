package com.javabasic.jvm.chapter4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * jconsole
 * @author win7
 *
 */
public class ThreadWaitTest {
	
	public static void createBusyThread(){
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true);
			}
		},"testBusyThread").start();;
	}
	
	public static void createLockThread(Object lock){
		new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (lock) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		},"testLockThread").start();;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		bufferedReader.readLine();
		createBusyThread();
		bufferedReader.readLine();
		
		System.out.println(">>>>>>>>>>>>>>>>>>");
		
		Object object = new Object();
		createLockThread(object);
	}

}
