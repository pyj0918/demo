package com.dm.cj.single;

/**
 * 懒汉式单例模式2（要用的时候才去实例化） 多线程环境下的单例模式
 * 
 * @author angelo
 * 
 */
public class Singleton3 {

	private static volatile Singleton3 instance;

	private Singleton3() {
	}

	/**
	 * 这里保证只会实例化一次，也就是第一次进行实例化，接下来继续调用就不会去实例化
	 * 
	 * @return
	 */
	public static Singleton3 getInstance() {
		if (instance == null) {
			synchronized (Singleton3.class) {
				//双重活检(注意：需要使用volatile关键字对instance进行修饰)
				//加上volatile关键字是为了当instance更新后，工作内存将更新后的值重新放入主内存，这样当其他线程从主内存拿到instance时保证是最新的
				//工作内存可以理解成高速缓存
				if (instance == null) {
					instance = new Singleton3();
				}
			}
		}
		return instance;
	}
}
