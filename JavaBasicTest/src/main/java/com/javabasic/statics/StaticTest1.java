package com.javabasic.statics;

/**
 * static修饰变量
 * @author win7
 *
 */
class StaticTest1 {
	private static int x = 100;

	public static void main(String args[]) {
		StaticTest1 hs1 = new StaticTest1();
		hs1.x++;
		StaticTest1 hs2 = new StaticTest1();
		hs2.x++;
		hs1 = new StaticTest1();
		hs1.x++;
		StaticTest1.x--;
		System.out.println("x=" + x);
	}
}
