package com.javabasic.collection.list;

import java.util.LinkedList;
import java.util.List;

/**
 * 线程不同步
 * 
 * @author wangymd
 *
 */
public class LinkedListTest {

	public static void main(String[] args) {
		List<String> list = new LinkedList<String>();
		list.add("wym");
		list.add(null);
	}
}
