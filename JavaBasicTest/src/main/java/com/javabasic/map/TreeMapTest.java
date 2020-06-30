package com.javabasic.map;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 允许使用null键和null值； 线程不同步，效率高；
 * 
 * @author wangymd
 *
 */
public class TreeMapTest {

	public static void main(String[] args) {
		TreeMap<String, String> treeMap = new TreeMap<String, String>();
		treeMap.put("k1", "v1");
		treeMap.put("k3", "v3");
		treeMap.put("k2", "v2");
		treeMap.put("k4", "v4");
		treeMap.put("k5", "v5");
		System.out.println(treeMap);
		System.out.println("lowerKey:" + treeMap.lowerKey("k1"));
		System.out.println("lowerKey:" + treeMap.lowerEntry("k1"));
		
		System.out.println("higherKey:" + treeMap.higherKey("k1"));
		System.out.println("higherEntry:" + treeMap.higherEntry("k1"));
		
		System.out.println("floorKey:" + treeMap.floorKey("k1"));
		System.out.println("floorEntry:" + treeMap.floorEntry("k1"));
		
		System.out.println("ceilingEntry:" + treeMap.ceilingEntry("k1"));
		System.out.println("ceilingKey:" + treeMap.ceilingKey("k1"));
		
		System.out.println("firstEntry:" + treeMap.firstEntry());
		System.out.println("lastEntry:" + treeMap.lastEntry());
		
		System.out.println("pollFirstEntry:" + treeMap.pollFirstEntry());
		System.out.println("pollLastEntry:" + treeMap.pollLastEntry());
		
		System.out.println("subMap:" + treeMap.subMap("k1","k3"));
		System.out.println("headMap:" + treeMap.headMap("k2"));
		System.out.println(">>>>>>>>>>>>>>>>>");
		
		MyComparator myComparator = new TreeMapTest().new MyComparator();
		Map<User, String> treeMap2 = new TreeMap<User, String>(myComparator);
		treeMap2.put(new User(1, "1", 1), "v1");
		treeMap2.put(new User(3, "3", 3), "v3");
		treeMap2.put(new User(2, "2", 2), "v2");
		System.out.println(treeMap2);
	}
	
	
	class MyComparator implements Comparator<User>{

		@Override
		public int compare(User o1, User o2) {
			if(o1.getId() > o2.getId()) return 1;
			if(o1.getId() < o2.getId()) return -1;
			return 0;
		}
		
	}
	
	class MyComparable implements Comparable{

		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}

}
