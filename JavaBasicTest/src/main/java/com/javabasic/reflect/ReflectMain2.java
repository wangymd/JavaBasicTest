package com.javabasic.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;

/**
 * 类的构造方法
 * @author win7
 *
 */
public class ReflectMain2 {

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
		
		//创建类实例
		ReflectDemo newInstance3 = (ReflectDemo)clazz3.newInstance();
		System.out.println(newInstance3.toString());
		System.out.println(">>>>>>>>>>>>>>>>>");
		
		//获取类中所有构造方法public
		Constructor<?>[] constructors = clazz3.getConstructors();
		for (Constructor constructor : constructors) {
			System.out.println("getConstructors:" + constructor.getName());
		}
		System.out.println(">>>>>>>>>>>>>>>>>");
		
		//获取类中所有构造方法public
		Constructor<?>[] declaredConstructors = clazz3.getDeclaredConstructors();
		for (Constructor constructor : declaredConstructors) {
			System.out.println("getDeclaredConstructors:" + constructor.getName());
		}
		System.out.println(">>>>>>>>>>>>>>>>>");
		
		Constructor<?> constructor = clazz3.getConstructor(new Class[]{Integer.class, String.class});
		System.out.println(constructor);
		ReflectDemo newInstance5 = (ReflectDemo)constructor.newInstance(1, "wym");
		System.out.println(newInstance5);
		System.out.println(">>>>>>>>>>>>>>>>>");
		
		Constructor<?> declaredConstructor = clazz3.getDeclaredConstructor(Integer.class);
		declaredConstructor.setAccessible(true);
		ReflectDemo newInstance4 = (ReflectDemo)declaredConstructor.newInstance(1);
		System.out.println(newInstance4);
		System.out.println(">>>>>>>>>>>>>>>>>");
		
		
		Class<?>[] parameterTypes = constructor.getParameterTypes();
		for (Class clazz : parameterTypes) {
			System.out.println("getParameterTypes:" + clazz);
		}
		System.out.println(">>>>>>>>>>>>>>>>>");
		
		Annotation[] annotations = constructor.getAnnotations();
		for (Annotation annotation : annotations) {
			System.out.println("getAnnotations:" + annotation);
		}
		System.out.println(">>>>>>>>>>>>>>>>>");
		
		Annotation[] declaredAnnotations = constructor.getDeclaredAnnotations();
		for (Annotation annotation : declaredAnnotations) {
			System.out.println("getDeclaredAnnotation:" + annotation);
		}
		System.out.println(">>>>>>>>>>>>>>>>>");

	}

}
