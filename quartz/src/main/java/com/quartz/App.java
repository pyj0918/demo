package com.quartz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	static final ApplicationContext CONTEXT;

	static {
		CONTEXT = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml", "quartz.xml" });// "quartz.xml"
	}

	public static void main(String[] args) {
		System.out.println("start");
	}
}
