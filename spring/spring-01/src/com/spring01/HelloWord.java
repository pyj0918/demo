package com.spring01;

public class HelloWord {
	private String name;

	public void setName2(String name) {
		this.name = name;
		System.out.println("name:" + name);
	}

	public void hello() {
		System.out.println("hello:" + name);
	}

	public HelloWord() {
		System.out.println("¹¹Ôì º¯Êý:HelloWord");
	}
}
