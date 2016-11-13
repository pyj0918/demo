package com.dm.cj.factory1;

public class Client {
	public static void main(String[] args) {
		MobileFactory mf = new MobileFactory();
		IMobile m;
		m = mf.getMobile("nokia");
		m.call();
		m = mf.getMobile("motorola");
		m.call();
	}
}
