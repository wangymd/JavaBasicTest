package com.javabasic.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * HashMap数据结构分析
 * @author wangymd
 *
 */
public class HashMapTest3 {

	public static void main(String[] args) {
		String[] keyPrefix = {"a","b","c","d","e","f","j","h"};
		Map<String,String> hashMap = new HashMap<String, String>();
		Set<Integer> hashSet = new HashSet<Integer>();
		for (String prefix : keyPrefix) {
			for (int i = 0; i < 1000; i++) {
				String keyVal = prefix + i;
//				hashSet.add(hashMap.size() & hash(keyVal));
				hashMap.put(keyVal, keyVal);
			}
			
		}
		System.out.println(hashSet.size());
		System.out.println(hashMap.size());
	}
	
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
