package com.inner1;

public class Client {
	public static void main(String[] args) {
		Out out = new Out();
		//常规内部类需要通过外部类的实例才能创建对象，与实例变量需要通过对象来访问相似
		Out.Inner inner = out.new Inner();
		inner.innerMethod();
	}
}
