package com.inner3;

public class Client {
	public static void main(String[] args) {
		Object obj = new Out().makeInner(33);
		System.out.println(obj.toString());
	}
}
