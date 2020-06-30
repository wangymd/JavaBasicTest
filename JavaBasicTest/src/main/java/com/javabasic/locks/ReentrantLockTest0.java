package com.javabasic.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock
 * 
 * @author win7
 *
 */
public class ReentrantLockTest0 {

	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		Condition newCondition = lock.newCondition();
		lock.lock();//如果未获取到锁，抛出java.lang.IllegalMonitorStateException异常
		try {
			System.out.println("start wait");
			newCondition.await();//释放锁，阻塞挂起；创建Node.CONDITION节点，追加到条件队列
			System.out.println("end wait");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();//释放锁
		}
		
		lock.lock();
		try {
			System.out.println("start signal");
			newCondition.signal();//相当于notify()方法；移除条件队列，放入同步AQS队列
			System.out.println("end signal");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}

	}

}
