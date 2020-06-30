package com.javabasic.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LinkedHashMap源码分析
 * 
 * 1、键值对允许为空
 * 2、存储数据有序
 * 
 * @author wangymd
 *
 */
public class LinkedHashMapTest {

	static final int MAXIMUM_CAPACITY = 1 << 30;
	
	public static void main(String[] args) {
		Map<String, String> hashMap = new HashMap<String, String>();
		hashMap.put(null, null);
		hashMap.put("1", "1");
		hashMap.put("3", "3");
		hashMap.put("2", "2");
		System.out.println(hashMap);
		
		Map<String, String> linkedHashMap = new LinkedHashMap<String, String>();
		linkedHashMap.put(null, null);
		linkedHashMap.put("1", "1");
		linkedHashMap.put("3", "3");
		linkedHashMap.put("2", "2");
		System.out.println(linkedHashMap);
	}
	
}
