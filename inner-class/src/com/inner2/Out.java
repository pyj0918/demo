package com.inner2;

/**
 * ��̬�ڲ���
 * 
 * @author Administrator
 * 
 */
public class Out {
	public static int x = 100;

	// ��̬�ڲ���
	public static class Inner {
		private String y = "hello";

		public void innerMethod() {
			System.out.println("x=" + x);
			System.out.println("y=" + y);
		}
	}
}
