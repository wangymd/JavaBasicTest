package com.javabasic.synchronizeds.singleton;
public class Singleton {

	/**
	 * 禁止指令重排
	 */
    private volatile static Singleton uniqueInstance;

    private Singleton() {}

    public synchronized static Singleton getUniqueInstance() {
       //先判断对象是否已经实例过，没有实例化过才进入加锁代码
        if (uniqueInstance == null) {
            //类对象加锁
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                	/**
                	 * 1、为 uniqueInstance分配内存空间
                	 * 2、初始化 uniqueInstance 
                	 * 3、将 uniqueInstance 指向分配的内存地址
                	 * 
                	 * JVM指令重排，执行顺序有可能变成 1->3->2
                	 * 
                	 */
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}