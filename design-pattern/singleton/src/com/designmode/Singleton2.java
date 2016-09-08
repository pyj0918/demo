package com.designmode;

/**
 * 方式二(方式一的简写)
 * 推荐使用
 * @author angelo
 *
 */
public class Singleton2 {
	//使用静态私有全局变量保存唯一的实例
	private static Singleton2 singleton=new Singleton2();
	private Singleton2(){}
	/**
	 * 这里保证只会实例化一次，也就是第一次进行实例化，接下来继续调用就不会去实例化
	 * @return
	 */
	public static Singleton2 getInstance(){
		return singleton;
	}
}
