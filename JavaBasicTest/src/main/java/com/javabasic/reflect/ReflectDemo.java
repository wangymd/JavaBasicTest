package com.javabasic.reflect;

import java.util.List;

/**
 * 反射学习
 * @author win7
 *
 */
public class ReflectDemo {//反射学习
	
	public final static String PUBLIC_fIELD = "publicField";
	
	private Integer id;//id
	
	private String name;//name
	
	private List<String> list;
	
	/**
	 * 无参构造
	 */
	public ReflectDemo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 有参构造
	 */
	public ReflectDemo(Integer id) {
		super();
		this.id = id;
	}

	/**
	 * 有参构造
	 */
	public ReflectDemo(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	//getId
	public Integer getId() {
		return id;
	}

	//setId
	public void setId(Integer id) {
		this.id = id;
	}

	//getName
	public String getName() {
		return name;
	}

	//setName
	public void setName(String name) {
		this.name = name;
	}
	
	private void print() {
		System.out.println("private method!!!");
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "ReflectDemo [id=" + id + ", name=" + name + "]";
	}

}
