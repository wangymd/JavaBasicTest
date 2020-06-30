package com.javabasic.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MyConcurrentHashMap {

	public static void main(String[] args) {
		Map<String,String> concurrentHashMap = new ConcurrentHashMap<String,String>();
		concurrentHashMap.put("k1", "v1");
		concurrentHashMap.put("k2", "v2");
		System.out.println(concurrentHashMap);
	}

}
