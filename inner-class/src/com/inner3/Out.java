package com.inner3;

/**
 * 局部内部类
 * 
 * @author Administrator
 * 
 */
public class Out {
	private int size = 5, y = 7;

	public Object makeInner(int localVar) {
		final int finalLocalVar = localVar;
		// 创建局部内部类，该类只在makeInner（）方法有效，就像局部变量一样。在方法体外部不能创建MyInner类的对象
		class Inner {
			int y = 4;

			public String toString() {
				return "OuterSize:" + size + "\nfinalLocalVar" + " " + "this.y=" + this.y;
			}
		}
		return new Inner();
	}
	
}
