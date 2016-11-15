package com.inner4;

public class Out {
	/**
	 * 1.匿名内部类可以继承一个类或实现一个接口， 但匿名内部类不能同时实现一个接口和继承一个类
	 * ，也不能实现多个接口。如果实现了一个接口，该类是Object类的直接子类，匿名类继承一个类或实现一个接口
	 * ，不需要extends和implements关键字
	 * 2.由于匿名内部类没有名称，所以类体中不能定义构造方法，由于不知道类名也不能使用关键字来创建该类的实例
	 * 。实际上匿名内部类的定义、构造、和第一次使用都发生在同样一个地方
	 * 
	 * @return
	 */
	public Object makeInner1() {

		return new Object() {
			public String toString() {
				return "OuterSize=\nfinalLocalVar=";
			}
		};
	}

	public String makeInner2() {
		new My() {

		};
		return null;
	}
}

interface My {

}
