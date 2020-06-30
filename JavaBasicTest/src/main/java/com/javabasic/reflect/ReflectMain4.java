package com.javabasic.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
/**
 * 类的成员方法
 * @author win7
 *
 */
public class ReflectMain4 {

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
		
		Method method = clazz3.getMethod("setName", new Class[]{String.class});
		method.setAccessible(true);
		method.invoke(newInstance3, "wym1");
		System.out.println(newInstance3);
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

		//获取泛型信息
		Method declaredMethod = clazz3.getDeclaredMethod("getList", null);
		Type genericReturnType = declaredMethod.getGenericReturnType();
		if(genericReturnType instanceof ParameterizedType){
		    ParameterizedType type = (ParameterizedType) genericReturnType;
		    Type[] typeArguments = type.getActualTypeArguments();
		    for(Type typeArgument : typeArguments){
		        Class typeArgClass = (Class) typeArgument;
		        System.out.println("typeArgClass = " + typeArgClass);
		    }
		}
		System.out.println(">>>>>>>>>>>>>>>>>");
		
		//获取泛型信息
		Method declaredMethod2 = clazz3.getDeclaredMethod("setList", List.class);
		Type[] genericParameterTypes = declaredMethod2.getGenericParameterTypes();
		for(Type genericParameterType : genericParameterTypes){
		    if(genericParameterType instanceof ParameterizedType){
		        ParameterizedType aType = (ParameterizedType) genericParameterType;
		        Type[] parameterArgTypes = aType.getActualTypeArguments();
		        for(Type parameterArgType : parameterArgTypes){
		            Class parameterArgClass = (Class) parameterArgType;
		            System.out.println("parameterArgClass = " + parameterArgClass);
		        }
		    }
		}
		System.out.println(">>>>>>>>>>>>>>>>>");
	}

}
