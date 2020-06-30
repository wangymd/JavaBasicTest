package com.javabasic.exception;

import java.lang.Thread.UncaughtExceptionHandler;
/**
 * 捕获线程异常信息
 * @author win7
 *
 */

public class CatchThreadExceptionTest1 {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		try {
			Thread thread = new Thread(new ExceptionThreadTest1());
			thread.setName("thread1");
			//线程发生的异常，try..catch无法捕获
			//设置默认未知异常处理类
			thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {
				public void uncaughtException(Thread t, Throwable e) {
					System.out.println("catch到了！");
					System.out.println(t.getName() + ":" + e.getMessage());
					StackTraceElement[] stackTraces = e.getStackTrace();
					for (int i = 0; i < stackTraces.length; i++) {
						StackTraceElement stackTrace = stackTraces[i]; 
						System.out.println(stackTrace.getClassName() + ":" + stackTrace.getMethodName() + ":" + stackTrace.getLineNumber());
					}
				}
			});
			thread.start();
		} catch (Exception e) {
			System.out.println("catch不到！");
		}
	}
}
