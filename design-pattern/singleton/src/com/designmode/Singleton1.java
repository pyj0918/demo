package com.designmode;
/**
 * 方式一(不推荐使用)
 * @author angelo
 *
 */
public class Singleton1 {
	//使用静态私有全局变量保存唯一的实例
	private static Singleton1 singleton;
	private Singleton1(){}
	/**
	 * 这里保证只会实例化一次，也就是第一次进行实例化，接下来继续调用就不会去实例化
	 * @return
	 */
	public static Singleton1 getInstance(){
		if (null==singleton){
			singleton=new Singleton1();
		}
		return singleton;
	}
	
}
