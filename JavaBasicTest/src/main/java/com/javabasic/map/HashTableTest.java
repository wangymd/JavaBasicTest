package com.javabasic.map;

import java.util.Hashtable;
import java.util.Map;

/**
 * 线程同步，效率低
 * 
 * @author wangymd
 *
 */
public class HashTableTest {

	public static void main(String[] args) {
		Map<String, String> map = new Hashtable<String, String>();
		map.put("name", "wym");
		//map.put(null, "");//java.lang.NullPointerException
		//map.put("key", null);//java.lang.NullPointerException
		map.put(null, null);//java.lang.NullPointerException
		System.out.println(map.size());
	}

}
