package com.javabasic.locks.mylock;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;

/**
 * 自定排它锁
 * @author win7
 *
 */
public class MyUnReentrantLockTest {
	
	final static MyUnReentrantLock myLock = new MyUnReentrantLock();
	final static Condition notFull = myLock.newCondition();
	final static Condition notEmpty = myLock.newCondition();
	
	//
	final static Queue<String> queue = new LinkedBlockingQueue<String>();
	final static Integer queueSize = 10;

	public static void main(String[] args) {
		//生产者
		Thread producer = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					System.out.println("生产者>>>:" + queue.size());
					myLock.lock();
					try {
						//队列已满，阻塞生产者线程
						while(queue.size() == queueSize) notFull.await();
						
						System.out.println("生产元素。。。");
						queue.add("p");
						notEmpty.signalAll();//唤醒消费进程
					}catch (Exception e) {
						e.printStackTrace();
					}finally {
						System.out.println("生产者释放锁");
						myLock.unlock();
					}
				}
			}
		});
		
		//消费者
		Thread consumer = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					System.out.println("消费者>>>:" + queue.size());
					myLock.lock();
					try {
						//队列空，唤醒生产者进行生产
						while(queue.size() == 0) notEmpty.await();//while是为了避免虚假唤醒
						
						System.out.println("消费元素。。。");
						queue.poll();
						notFull.signalAll();//唤醒消费进程
					}catch (Exception e) {
						e.printStackTrace();
					}finally {
						System.out.println("消费者释放锁");
						myLock.unlock();
					}
				}
			}
		});
		
		producer.start();
		consumer.start();

	}

}
