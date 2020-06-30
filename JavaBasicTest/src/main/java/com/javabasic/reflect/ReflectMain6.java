package com.javabasic.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/**
 * 类的成员方法
 * @author win7
 *
 */
public class ReflectMain6 {

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
		
		System.out.println(clazz1 == clazz2);
		System.out.println(clazz2 == clazz3);
		System.out.println(clazz3 == clazz1);
		
		//创建类实例
		ReflectDemo newInstance3 = (ReflectDemo)clazz3.newInstance();
		System.out.println(newInstance3.toString());
		System.out.println(">>>>>>>>>>>>>>>>>");
		
		//获取类中所有public成员属性
		Field[] fields = clazz3.getFields();
		for (Field field : fields) {
			System.out.println("getFields:" + field.getName());
		}
		System.out.println(">>>>>>>>>>>>>>>>>");
		
		//获取类中所有定义成员属性
		Field[] declaredFields = clazz3.getDeclaredFields();
		for (Field field : declaredFields) {
			System.out.println("getDeclaredFields:" + field.getName());
		}
		System.out.println(">>>>>>>>>>>>>>>>>");
		
		Field nameDeclaredField = clazz3.getDeclaredField("name");
		nameDeclaredField.setAccessible(true);
		nameDeclaredField.set(newInstance3, "wym");
		System.out.println(newInstance3);
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
		
		Constructor<?> declaredConstructor = clazz3.getDeclaredConstructor(Integer.class);
		declaredConstructor.setAccessible(true);
		ReflectDemo newInstance4 = (ReflectDemo)declaredConstructor.newInstance(1);
		System.out.println(newInstance4);
		System.out.println(">>>>>>>>>>>>>>>>>");
		
		//获取类中所有public成员方法
		Method[] methods = clazz3.getMethods();
		for (Method method : methods) {
			System.out.println("getMethods:" + method.getName());
		}
		System.out.println(">>>>>>>>>>>>>>>>>");
		
		Method[] declaredMethods = clazz3.getDeclaredMethods();
		for (Method method : declaredMethods) {
			System.out.println("getDeclaredMethods:" + method.getName());
		}
		System.out.println(">>>>>>>>>>>>>>>>>");
		
		//获取指定方法并调用
		Method setIdMethod = clazz3.getDeclaredMethod("setId", Integer.class);
		setIdMethod.invoke(newInstance3, 1);
		System.out.println(newInstance3);
		System.out.println(">>>>>>>>>>>>>>>>>");
		
		Method privateDeclaredMethod = clazz3.getDeclaredMethod("print", null);
		privateDeclaredMethod.setAccessible(true);
		privateDeclaredMethod.invoke(newInstance3, null);
		
		Annotation[] annotations = clazz3.getAnnotations();
		for (Annotation annotation : annotations) {
			System.out.println("getAnnotations:" + annotation);
		}
		System.out.println(">>>>>>>>>>>>>>>>>");
		
		Annotation[] declaredAnnotations = clazz3.getDeclaredAnnotations();
		for (Annotation annotation : declaredAnnotations) {
			System.out.println("getDeclaredAnnotations:" + annotation);
		}
		System.out.println(">>>>>>>>>>>>>>>>>");

	}

}
