package com.javabasic.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * CGLib代理
 * @author win7
 *
 */
public class CglibProxyTest1 {
	
	static class CglibSuperClassTest1{
		
		public String run(String msg) {
			System.out.println("I am ok.");
			return "ok";
		}
	}
	
	public static void main(String[] args) throws Exception {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(CglibSuperClassTest1.class);
		enhancer.setUseCache(false);
		enhancer.setCallback(new MethodInterceptor() {
			@Override
			public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
				System.out.println("cglib proxy is running.");
				return proxy.invokeSuper(obj, args);
			}
		});
		CglibSuperClassTest1 cglibSuperClassTest1 = (CglibSuperClassTest1)enhancer.create();
		cglibSuperClassTest1.run("Are you ok?");
	}

}
