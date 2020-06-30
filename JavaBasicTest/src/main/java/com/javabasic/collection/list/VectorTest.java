package com.javabasic.collection.list;

import java.util.List;
import java.util.Vector;

/**
 * 线程同步
 * @author wangymd
 *
 */
public class VectorTest {
	
	public static void main(String[] args) {
		List<String> list = new Vector<String>();
		list.add("wym");
		list.add(null);
	}

}
