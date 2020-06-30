package com.javabasic.thread.callable;

import java.util.concurrent.Callable;
/**
 * Callable 接口类似于 Runnable，两者都是为那些其实例可能被另一个线程执行的类设计的。
 * 但是 Runnable 不会返回结果，并且无法抛出经过检查的异常
 * @author win7
 *
 */
public class CallableTest1 implements Callable<String>{
	
	private boolean status = false;
	
	public String call() throws Exception {
		
		System.out.println("CallableDemo1执行了。。。");
		
		for (int i = 0; i <20; i++) {
			Thread.sleep(300);
			System.out.println("循环：" + i);
		}
		
		if(status){
			return "sucess";
		}else{
			return "false";
		}
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
