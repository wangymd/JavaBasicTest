package com.javabasic.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;

/**
 * 类的信息
 * @author win7
 *
 */
public class ReflectMain1 {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		//1、知道具体类的情况下可以使用
		ReflectDemo newInstance1 = new ReflectDemo();
		Class clazz1 = newInstance1.getClass();
		
		//2、知道具体类的情况下可以使用
		Class clazz2 = ReflectDemo.class;
		ReflectDemo newInstance2 = (ReflectDemo)clazz2.newInstance();
		
		//3、通过 Class.forName()传入类的路径获取
		Class<?> clazz3 = Class.forName("reflect.demo.ReflectDemo");
		
		//Class只有一个对象
		System.out.println(clazz1 == clazz2);
		System.out.println(clazz2 == clazz3);
		System.out.println(clazz3 == clazz1);
		System.out.println(">>>>>>>>>>>>>>>>>");
		
		//类名称
		System.out.println("getName:" + clazz3.getName());
		System.out.println("getSimpleName:" + clazz3.getSimpleName());
		System.out.println("getTypeName:" + clazz3.getTypeName());
		System.out.println(">>>>>>>>>>>>>>>>>");
		
		//创建类实例
		ReflectDemo newInstance3 = (ReflectDemo)clazz3.newInstance();
		System.out.println(newInstance3.toString());
		System.out.println(">>>>>>>>>>>>>>>>>");
		
		//类包
		Package package1 = clazz3.getPackage();
		System.out.println("getPackage:" + package1);
		System.out.println(">>>>>>>>>>>>>>>>>");
		
		//类修饰符
		int modifiers = clazz3.getModifiers();
		System.out.println("getModifiers:" + modifiers);
		System.out.println("isPublic:" + Modifier.isPublic(modifiers));
		System.out.println(">>>>>>>>>>>>>>>>>");
		
		//获取类的父类
		Class<?> superclass = clazz3.getSuperclass();
		System.out.println("getSuperclass:" + superclass);
		System.out.println(">>>>>>>>>>>>>>>>>");
		
		//获取类实现接口
		Class<?>[] interfaces = clazz3.getInterfaces();
		for (Class clazz : interfaces) {
			System.out.println("getInterfaces:" + clazz);
		}
		System.out.println(">>>>>>>>>>>>>>>>>");
		
		Annotation[] annotations = clazz3.getAnnotations();
		for (Annotation annotation : annotations) {
			System.out.println("getAnnotations:" + annotation);
		}
		System.out.println(">>>>>>>>>>>>>>>>>");
		
		Annotation[] declaredAnnotations = clazz3.getDeclaredAnnotations();
		for (Annotation annotation : declaredAnnotations) {
			System.out.println("getDeclaredAnnotation:" + annotation);
		}
		System.out.println(">>>>>>>>>>>>>>>>>");

	}
}