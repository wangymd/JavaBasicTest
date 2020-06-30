package com.javabasic.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

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
public class HashMapTest2 {

	public static void main(String[] args) {
		Stu stu1 = new Stu(1,"xiaojia");
		Stu stu2 = new Stu(1,"xiaoyi");
		Stu stu3 = new Stu(1,"xiaobing");
		Stu stu4 = new Stu(1,"xiaoding");
		
		Map<Stu, String> hm = new HashMap<Stu, String>();
		hm.put(stu1, "xiaojia");
		hm.put(stu2, "xiaoyi");
		hm.put(stu3, "xiaobing");
		hm.put(stu4, "xiaoding");
		
		Set<Entry<Stu, String>> entrySet = hm.entrySet();
		for (Entry<Stu, String> entry : entrySet) {
			Stu key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key.getName() + "----" + value);
		}
	}
	

}

class Stu{
	
	Integer id;
	String name;
	public Stu() {}
	
	public Stu(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
