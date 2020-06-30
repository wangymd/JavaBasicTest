package com.javabasic.str;

public class StringTest2 {

	public static void main(String[] args) {
		String s1 = new String("abc");//该行创建两个对象，第一个对象是"abc"字符串存储在常量池中，第二个对象在JAVA Heap中的String对象。(JDK8都在堆内存)
		String s2 = "abc";//JDK8直接存储在堆内存字符常量池
		String s3 = "abc";//JDK8直接存储在堆内存字符常量池
		System.out.println(s1==s2);//false
		System.out.println(s2==s3);//true
		System.out.println("1>>>>>>>>>>>>>>>");
		
		String s4 = new String("hello");
		s4.intern();//调用intern方法，查询字符常量池是否存在，如果不存在就放入
		String s5 = "hello";//JDK8直接存储在堆内存字符常量池
		System.out.println(s4==s5);//false
		System.out.println("2>>>>>>>>>>>>>>>");
		
		//字符串拼接方式，等同于
		String s6 = new String("123") + new String("123");
		s6.intern();//如果没有结果false，
		String s7 = "123123";//JDK8直接存储在堆内存字符常量池
		System.out.println(s6==s7);//true
		System.out.println("3>>>>>>>>>>>>>>>");
		
//		String s8 = "456" + new String("456");
		String s8 = new String("456") + "456";
		s8.intern();//如果没有结果false
		String s9 = "456456";//JDK8直接存储在堆内存字符常量池
		System.out.println(s8==s9);//true
		System.out.println("4>>>>>>>>>>>>>>>");
		
		String s10 = "789" + "789";
//		s10.intern();
		String s11 = "789789";//JDK8直接存储在堆内存字符常量池
		System.out.println(s10==s11);//true
		System.out.println("5>>>>>>>>>>>>>>>");
		
		String s12 = new String("789789");
		System.out.println(s11==s12);//false
		System.out.println("6>>>>>>>>>>>>>>>");
	}

}
