package com.dm.cj.single;


/**
 * 
 * 饿汗式 饿汗式虽然免除了多线程所带来的影响，但是该对象是在类加载的时候就放到内存。如果该对象足够大，占用资源较多，势必会影响程序的性能
 * 
 * @author angelo
 * 
 */
public class Singleton1 {
	// 使用静态私有全局变量保存唯一的实例
	private static Singleton1 singleton = new Singleton1();

	private Singleton1() {
	}

	/**
	 * 这里保证只会实例化一次，也就是第一次进行实例化，接下来继续调用就不会去实例化
	 * 
	 * @return
	 */
	public static Singleton1 getInstance() {
		return singleton;
	}
}
