package com.dm.cj.factory2;

public class Client {
	public static void main(String[] args) {
		MobileFactory factory;
		IMobile mobile;
		
		factory = new NokiaFactory();
		mobile = factory.createMobile();
		
		factory = new MotorolaFactory();
		mobile = factory.createMobile();
	}
}
