package com.javabasic.packages.p1;

import com.javabasic.packages.p2.PackageTest2;

public class PackageTest1 {
	
	String msg1(String msg) {
		System.out.println(msg);
		return "msg1";
	}
	
	protected String msg2(String msg) {
		System.out.println(msg);
		return "msg2";
	}
	
	public static void main(String[] args) {
		PackageTest2 test2 = new PackageTest2();
	}

}
