package com.javabasic.collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 线程不同步
 * @author wangymd
 *
 */
public class ArrayListTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>(0);
		
		list.add("wym");
		list.add(null);

	}

}
