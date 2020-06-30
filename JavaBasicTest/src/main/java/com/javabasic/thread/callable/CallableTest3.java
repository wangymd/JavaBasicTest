package com.javabasic.thread.callable;

import java.util.concurrent.Callable;
/**
 * Callable 接口类似于 Runnable，两者都是为那些其实例可能被另一个线程执行的类设计的。
 * 但是 Runnable 不会返回结果，并且无法抛出经过检查的异常
 * @author win7
 *
 */
public class CallableTest3 implements Callable<Integer>{
	
	private Integer ret = 0;
	
	private String name ;
	
	private ThreadLocal<String> threadLocal = new ThreadLocal<String>();
	
	public CallableTest3(String name) {
		this.name = name;
	}
	
	public Integer call() throws Exception {
		threadLocal.set(name);
		for (int i = 0; i <20; i++) {
			ret ++;
		}
		
		return ret;
	}
	
	public ThreadLocal<String> getThreadLocal() {
		return threadLocal;
	}

	public void setThreadLocal(ThreadLocal<String> threadLocal) {
		this.threadLocal = threadLocal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
