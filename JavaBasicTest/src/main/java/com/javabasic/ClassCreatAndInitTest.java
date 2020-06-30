package com.javabasic;

import com.javabasic.map.User;

/**
 * 代码块执行顺序：测试
 * @author wangymd
 *
 */
public class ClassCreatAndInitTest {
	
//	生命周期
//	静态变量随着类的加载而存在，随着类的消失而消失。生命周期长。
//	成员变量随着对象的创建而存在，随着对象的消失而消失。
	static{//因为静态的内容是随着类的加载而加载，它是先进内存的。
		System.out.println("ConstructCodeTest类静态代码块！");
	}

	public static void main(String[] args) {
		User user = new User();
//		(1)将User.class文件加载进内存中。
//		(2)如果user定义在主方法中，那么，就会在栈空间开辟一个变量空间p。
//		(3)在堆内存给对象分配空间。
//		(4)对对象中的成员进行默认初始化。
//		(5)对对象中的成员进行显示初始化。
//		(6)调用构造代码块对对象进行初始化。(如果没有就不执行)
//		(7)调用构造方法对对象进行初始化。对象初始化完毕。
//		(8)将对象的内存地址赋值给p变量，让user变量指向该对象。
		
//		user.setName("wangymd");
		user.setAge(18);
		System.out.println(user);
	}

}
