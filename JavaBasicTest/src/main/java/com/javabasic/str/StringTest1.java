package com.javabasic.str;

public class StringTest1 {

	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "abc";
		String s3 = new String("abc");
		String s4 = "ab" + "c";

		System.out.println("s1与s2：" + (s1 == s2));// true
		System.out.println("s1与s3：" + (s1 == s3));// false
		System.out.println("s1与s4：" + (s1 == s4));// true
		System.out.println("s3与s4：" + (s3 == s4));// false

		// 面试题
		String s5 = new String("xyz");
		String s6 = new String("xyz");
		System.out.print((s5.equals(s6)) + "-" + (s5 == s6));//true-false
		
		String str1 = "hello";
		String str2 = "he" + new String("llo");
		System.err.println(str1 == str2);//false
	}

}
