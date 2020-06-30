package com.javabasic.jvm.chapter2;

/**
 * 虚拟机栈和本地方法栈OOM测试
 *- -verbose:gc -Xss2m
 * java.lang.StackOverflowError
 * @author win7
 *
 */
public class JavaVMStackOOM {
	
	private void donotStop() {
		while (true) {}
	}
	
	public void stackLeakByThread() {
		while (true) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					donotStop();
				}
			}).start();
		}
	}

	public static void main(String[] args) throws Exception {
		JavaVMStackOOM oom = new JavaVMStackOOM();
		oom.stackLeakByThread();
	}

}
