package com.javabasic.threadlocal;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 同步方式学习
 * @author wangymd
 *
 */
public class ThreadLocalMainTest {
	
	public static final int THREAD_COUNT = 10;
	
	public static volatile int number = 1000;
	
	//注意这个地方:lock被声明为类成员变量,如果声明为局部变量，将导致使用的是不同的锁
	private static Lock lock = new ReentrantLock();
	
	public static void main(String[] args) {
		for (int i = 0; i < THREAD_COUNT; i++) {
			new Thread(new Runnable() {
				public void run() {
					String name = Thread.currentThread().getName();
					try {
						//synchronizedTest(name);//同步方式1	yes
						//lockTest(name);//同步方式2		no
						//trylockTest(name);//同步方式3		no
						lockInterruptiblyTest(name);//同步方式4		
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			},"t" + i).start();
		}
		
		while (Thread.activeCount() > 1) {
			System.out.println("Thread.activeCount():" + Thread.activeCount());
			Thread.yield();
		}
		System.out.println("子线程执行完成！");
		System.out.println(number);
	}
	
	public synchronized static void synchronizedTest(String tHreadName){
		while(number > 0){
			System.out.println(tHreadName + ":" + number--);
		}
	}
	
	public static void lockTest(String tHreadName){
		while(number > 0){
			lock.lock();
			System.out.println(tHreadName + ":" + number--);
			lock.unlock();
		}
	}
	
	public static void trylockTest(String tHreadName){
		while(number > 0){
			if(lock.tryLock()){
				try {
					System.out.println(tHreadName + ":" + number--);
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					lock.unlock();
				}
			}else{
//			System.out.println(tHreadName + ":lock.tryLock()失败!");
			}
		}
}
	
	public static void lockInterruptiblyTest(String tHreadName) throws InterruptedException{
		while(number > 0){
			lock.lockInterruptibly();
			System.out.println(tHreadName + ":" + number--);
		}
	}

}
