package com.javabasic.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * 类的成员属性
 * 
 * @author win7
 *
 */
public class ReflectMain3 {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// 1、知道具体类的情况下可以使用
		ReflectDemo newInstance1 = new ReflectDemo();
		Class clazz1 = newInstance1.getClass();

		// 2、知道具体类的情况下可以使用
		Class clazz2 = ReflectDemo.class;
		ReflectDemo newInstance2 = (ReflectDemo) clazz2.newInstance();

		// 3、通过 Class.forName()传入类的路径获取
		Class<?> clazz3 = Class.forName("reflect.demo.ReflectDemo");

		// 创建类实例
		ReflectDemo newInstance3 = (ReflectDemo) clazz3.newInstance();
		System.out.println(newInstance3.toString());
		System.out.println(">>>>>>>>>>>>>>>>>");

		// 获取类中所有public成员属性
		Field[] fields = clazz3.getFields();
		for (Field field : fields) {
			System.out.println("getFields:" + field.getName());
		}
		System.out.println(">>>>>>>>>>>>>>>>>");

		// 获取类中所有定义成员属性
		Field[] declaredFields = clazz3.getDeclaredFields();
		for (Field field : declaredFields) {
			System.out.println("getDeclaredFields:" + field.getName());
		}
		System.out.println(">>>>>>>>>>>>>>>>>");

//		Field field = clazz3.getField("name");
//		field.setAccessible(true);
//		field.set(newInstance3, "wym1");
//		System.out.println(newInstance3);
//		System.out.println(">>>>>>>>>>>>>>>>>");

		Field nameDeclaredField = clazz3.getDeclaredField("name");
		nameDeclaredField.setAccessible(true);
		nameDeclaredField.set(newInstance3, "wym2");
		System.out.println(newInstance3);
		System.out.println(">>>>>>>>>>>>>>>>>");

		Annotation[] annotations = nameDeclaredField.getAnnotations();
		for (Annotation annotation : annotations) {
			System.out.println("getAnnotations:" + annotation);
		}
		System.out.println(">>>>>>>>>>>>>>>>>");

		Annotation[] declaredAnnotations = nameDeclaredField.getDeclaredAnnotations();
		for (Annotation annotation : declaredAnnotations) {
			System.out.println("getDeclaredAnnotation:" + annotation);
		}
		System.out.println(">>>>>>>>>>>>>>>>>");

		// 获取泛型信息
//		Field field = clazz3.getField("list");
//		Type genericType = field.getGenericType();
//		if (genericType instanceof ParameterizedType) {
//			ParameterizedType type = (ParameterizedType) genericType;
//			Type[] typeArguments = type.getActualTypeArguments();
//			for (Type typeArgument : typeArguments) {
//				Class typeArgClass = (Class) typeArgument;
//				System.out.println("fieldArgClass:" + typeArgClass);
//			}
//		}
//		System.out.println(">>>>>>>>>>>>>>>>>");

		// 获取泛型信息
		Field field2 = clazz3.getDeclaredField("list");
		Type genericType2 = field2.getGenericType();
		if (genericType2 instanceof ParameterizedType) {
			ParameterizedType aType = (ParameterizedType) genericType2;
			Type[] parameterArgTypes = aType.getActualTypeArguments();
			for (Type parameterArgType : parameterArgTypes) {
				Class parameterArgClass = (Class) parameterArgType;
				System.out.println("fieldArgClass:" + parameterArgClass);
			}
		}
		System.out.println(">>>>>>>>>>>>>>>>>");

	}

}
