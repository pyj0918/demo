package com.designmode;

/**
 * 方式三：懒汉式单例模式（要用的时候才去实例化）
 * 多线程环境下的单例模式
 * @author angelo
 *
 */
public class Singleton3 {
	//使用静态私有全局变量保存唯一的实例
	private static volatile Singleton3 singleton;
	private Singleton3(){}
	/**
	 * 这里保证只会实例化一次，也就是第一次进行实例化，接下来继续调用就不会去实例化
	 * @return
	 */
	public static Singleton3 getInstance(){
		if(singleton==null){
			synchronized(Singleton3.class){
				if(singleton==null){
					singleton=new Singleton3();
				}
			}
		}
		return singleton;
	}
}
