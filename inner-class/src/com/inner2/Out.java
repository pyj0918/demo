package com.inner2;

/**
 * 静态内部类
 * 
 * @author Administrator
 * 
 */
public class Out {
	public static int x = 100;

	// 静态内部类
	public static class Inner {
		private String y = "hello";

		public void innerMethod() {
			System.out.println("x=" + x);
			System.out.println("y=" + y);
		}
	}
}
