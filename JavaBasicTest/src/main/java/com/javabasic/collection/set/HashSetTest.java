package com.javabasic.collection.set;

import java.util.HashSet;
import java.util.Set;

/**
 * 对象唯一，不同步
 * 
 * HashSet(JDK1.2):底层数据结构是哈希表、存取速度快、元素唯一、线程不同步。 保证性元素唯一的原理:
 * 先判断元素的hashCode值是否相同，再判断两元素的equals方法是否为true
 * (往HashSet里面存的自定义元素要复写hashCode和equals方法， 以保证元素的唯一性！)
 * 
 * @author wangymd
 *
 */
public class HashSetTest {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();

		set.add("wym");
		set.add(null);

	}

}
