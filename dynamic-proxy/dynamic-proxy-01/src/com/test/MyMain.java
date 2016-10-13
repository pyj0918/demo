package com.test;

import java.io.FileOutputStream;

import sun.misc.ProxyGenerator;

public class MyMain {
	public static void main(String[] args) {
		Person person = new PersonImpl();
		DynamicProxy prox = new DynamicProxy(person);
		Person personProx = prox.getProxy();
		System.out.println(personProx.getClass().getName());
		personProx.say();
		personProx.work();
		createProxyClassFile();
	}

	//�鿴���ɵĴ����࣬������⶯̬����
	public static void createProxyClassFile() {
		String name = "$Proxy0";
		byte[] data = ProxyGenerator.generateProxyClass(name,new Class[] { Person.class });
		try {
			FileOutputStream out = new FileOutputStream(name + ".class");
			out.write(data);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
