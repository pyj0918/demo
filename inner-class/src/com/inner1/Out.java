package com.inner1;

/**
 * 常规内部类 应用场景：可以让常规内部类私有化，限制在其它地方使用
 * 
 * @author Administrator
 * 
 */
public class Out {
	private int x = 100;

	public void outMethod() {
		x++;
	}

	// 创建内部类
	// 加入private 可以限制在其它地方使用
	class Inner {
		private String y = "hello";

		public void innerMethod() {
			System.out.println("内部类中 String =" + y);
			System.out.println("外部类中的x =" + x);// 直接访问外部类中的实例变量x
			outMethod();
			System.out.println("x is " + Out.this.x);
		}
	}

	public void makeInner() {
		// 在外部类方法中创建内部类实例
		Inner in = new Inner();
	}
}
