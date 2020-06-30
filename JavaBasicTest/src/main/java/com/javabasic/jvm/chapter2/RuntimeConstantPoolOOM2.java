package com.javabasic.jvm.chapter2;

/**
 *  2-7 运行时常量池溢出
 * @author wangym
 *
 */
public class RuntimeConstantPoolOOM2 {

	public static void main(String[] args) {
		String str1 = new StringBuilder("计算机").append("软件").toString();
		System.out.println(str1.intern() == str1);
		
		String str2 = new StringBuilder("ja").append("va").toString();
		System.out.println(str2.intern() == str2);
		
	      String s1 = new String("计算机");//堆内存
	      String s2 = s1.intern();//s2常连池
	      String s3 = "计算机";
	      System.out.println(s2);//计算机
	      System.out.println(s1 == s2);//false，因为一个是堆内存中的String对象，一个是常量池中的String对象
	      System.out.println(s2 == s3);//true，因为两个都是常量池中的String对象
	      System.out.println(s3 == s1);//false，因为一个是堆内存中的String对象，一个是常量池中的String对象
	}

}
