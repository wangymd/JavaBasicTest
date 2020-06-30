package com.javabasic.collection.set;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import com.javabasic.map.User;

/**
 * 对象唯一，不同步
 * 
 * TreeSet:底层数据结构式二叉树。可以对Set集合中的元素进行排序。元素有序、线程不同步。 保证元素唯一性的依据：compareTo方法return
 * TreeSet排序的第一种方式:让元素自身具备比较性，比如八种基本数据类型或则字符串， 实现Compareble接口,覆盖compareTo方法，此方式是元素的自然顺序 
 * TreeSet排序的第一种方式:当元素自身不具备比较性(比如存储学生对象时)或者具备的比较性不是我们所需要的比较性时(比如想字符串的长度排序), 此时就需要
 * 让集合自身具备自定义的比较性。 
 * 那如何让集合自身具备比较性呢？可在集合初始化时，就让集合具备比较方式。即定义一个类， 实现Comparator接口，覆盖compare方法。
 * 
 * @author wangymd
 *
 */
public class TreeSetTest {

	public static void main(String[] args) {
		Set<String> set1 = new TreeSet<String>();

		set1.add("wym");
		set1.add(null);
		
		Set<User> set2 = new TreeSet<User>(new Comparator<User>() {

			public int compare(User o1, User o2) {
				// TODO
				return 0;
			}
		});

		set2.add(new User(1,"wym", 18));
		set2.add(new User(2,"wym", 18));
	}

}
