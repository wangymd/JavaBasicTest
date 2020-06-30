package com.javabasic.collection;

import java.util.Arrays;

public class ArraycopyTest {

	public static void main(String[] args) {
		int[] a = new int[10];
		a[0] = 0;
		a[1] = 1;
		a[2] = 2;
		a[3] = 3;
		System.arraycopy(a, 2, a, 3, 3);
		a[2]=99;
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		
		int[] b = Arrays.copyOf(a, 10);
		System.out.println("b.length"+b.length);
	}

}