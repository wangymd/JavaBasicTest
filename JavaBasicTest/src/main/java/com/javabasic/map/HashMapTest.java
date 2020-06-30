package com.javabasic.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 源码分析
 * 
 * 
 * 允许使用null键和null值； 
 * 线程不同步，效率高；
 * 
 * 
 * @author wangymd
 *
 */
public class HashMapTest {

	static final int MAXIMUM_CAPACITY = 1 << 30;
	
	public static void main(String[] args) {
		System.out.println(tableSizeFor(1));
		System.out.println(tableSizeFor(2));
		System.out.println(tableSizeFor(3));
		System.out.println(tableSizeFor(4));
		System.out.println(tableSizeFor(5));
		
		Map<String, String> hm = new HashMap<String, String>();
		System.out.println("初始化元素个数：" + (1 << 4));
		System.out.println("最大元素个数：" + (1 << 30));
		Random random = new Random();
		for(int i = 1; i <= 10000; i++) {
			String key = "key" + random.nextInt(20);
			String val = "value" + i;
			hm.put(key, val);
		}
		System.out.println(hm.size());
		System.out.println(hm.keySet());
		//System.out.println(hm.entrySet());
	}
	
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

}
