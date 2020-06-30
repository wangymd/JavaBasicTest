package com.javabasic.collection;

import java.util.Arrays;
import java.util.List;

public class ArraysDemo {
	
	static String[] arr = {"aaa", "bbb", "ccc"};

	public static void main(String[] args) {
		List<String> list = Arrays.asList(arr);
		System.out.println(list);
		
		//list.add("dddd");//java.lang.UnsupportedOperationException
		arr[0] = "a1a";
		System.out.println(list);
		
		int[] myArray = { 1, 2, 3 };
		List myList = Arrays.asList(myArray);
		System.out.println(myList.size());//1
		System.out.println(myList.get(0));//数组地址值
		//System.out.println(myList.get(1));//报错：ArrayIndexOutOfBoundsException
		int [] array=(int[]) myList.get(0);
		System.out.println(array[0]);//1
	}

}
