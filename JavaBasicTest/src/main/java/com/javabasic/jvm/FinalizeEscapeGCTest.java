package com.javabasic.jvm;

/**
 * 此代码演示两点
 * 1、对象可以在被GC是自我拯救
 * 2、这种自救的机会只有一次，因为一个对象的finalize()方法最多只会被系统自动调用一次
 * @author wangym
 *
 */
public class FinalizeEscapeGCTest {
	
	public static FinalizeEscapeGCTest finalizeEscapeGCTest = null;
	
	public void isAlive() {
		System.out.println("yes, I am still alive!");
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("finalize method executed!");
		finalizeEscapeGCTest = this;
	}

	public static void main(String[] args) throws InterruptedException {
		finalizeEscapeGCTest = new FinalizeEscapeGCTest();
		
		//对象第一次成功拯救自己
		finalizeEscapeGCTest = null;
		System.gc();
		//因为finalize方法优先级很低，所以暂停0.5秒以等待他
		Thread.sleep(500);
		if(finalizeEscapeGCTest != null) {
			finalizeEscapeGCTest.isAlive();
		}else {
			System.out.println("no, I am dead!");
		}
		
		//对象自救失败
		finalizeEscapeGCTest = null;
		System.gc();
		//因为finalize方法优先级很低，所以暂停0.5秒以等待他
		Thread.sleep(500);
		if(finalizeEscapeGCTest != null) {
			finalizeEscapeGCTest.isAlive();
		}else {
			System.out.println("no, I am dead!");
		}
	}

}
