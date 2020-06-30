package com.javabasic.jvm.chapter2;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 2-8 借助CGLib使方法区出现内存溢出异常
 * -verbose:gc -XX:PermSize=10m -XX:MaxPermSize=10m
 * java.lang.StackOverflowError
 * @author win7
 *
 */
public class JavaMethodAreaOOM {
	
	static class OOMObject{}
	
	public static void main(String[] args) throws Exception {
		while (true) {
			Enhancer enhancer = new Enhancer();
			enhancer.setSuperclass(OOMObject.class);
			enhancer.setUseCache(false);
			enhancer.setCallback(new MethodInterceptor() {
				@Override
				public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
					return proxy.invokeSuper(obj, args);
				}
			});
			enhancer.create();
		}
	}

}
