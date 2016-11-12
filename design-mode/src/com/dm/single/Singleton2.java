package com.dm.single;

/**
 * 懒汉式单例模式1（要用的时候才去实例化） 在单线程情况下不会出现任何问题，每次返回都是同一个对象,便在多线程情况下会出现线程安全的问题
 * 
 * @author angelo
 * 
 */
public class Singleton2 {
	// 使用静态私有全局变量保存唯一的实例
	private static Singleton2 singleton;

	private Singleton2() {
	}

	/**
	 * 这里保证只会实例化一次，也就是第一次进行实例化，接下来继续调用就不会去实例化
	 * 
	 * @return
	 */
	public static Singleton2 getInstance() {
		if (singleton == null) {
			singleton = new Singleton2();
		}
		return singleton;
	}
}
