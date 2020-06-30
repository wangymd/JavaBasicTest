package com.javabasic.jvm.chapter2;

/**
 * 虚拟机栈和本地方法栈OOM测试
 * -verbose:gc -Xss128k
 * java.lang.StackOverflowError
 * @author win7
 *
 */
public class JavaVMStackSOF {
	
	private int stackLength = 1;
	
	public void stackLeak() {
		stackLength++;
		stackLeak();
	}

	public static void main(String[] args) throws Exception {
		JavaVMStackSOF oom = new JavaVMStackSOF();
		try {
			oom.stackLeak();
		} catch (Exception e) {
			throw e;
		}finally {
			System.out.println("stackLength:" + oom.stackLength);
		}
	}

}
