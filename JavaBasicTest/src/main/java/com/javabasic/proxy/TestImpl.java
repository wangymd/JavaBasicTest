package com.javabasic.proxy;

public class TestImpl implements Test {

	@Override
	public String run(String msg) {
		System.out.println(msg);
		return "ok";
	}

}
