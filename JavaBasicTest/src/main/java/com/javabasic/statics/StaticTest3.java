package com.javabasic.statics;

/**
 * static修饰变量
 * 在子类中如果没有重新定义继承自父类的静态变量，那么子类和父类共享同一个静态变量
 * 在子类中重新定义静态变量 x
 * @author win7
 *
 */
class StaticTest3 extends Father{
	
	private static int x = 100;

	public static void main(String args[]) {
		x++;
		System.out.println("x=" + x);
	}
}