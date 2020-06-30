package com.javabasic.statics;

/**
 * static修饰变量
 * @author win7
 * 在子类中如果没有重新定义继承自父类的静态变量，那么子类和父类共享同一个静态变量
 * （1）没有在子类重新定义静态变量 x
 */
class StaticTest2 extends Father{

	public static void main(String args[]) {
		x++;
		System.out.println("x=" + x);
	}
}