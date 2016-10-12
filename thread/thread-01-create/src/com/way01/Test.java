package com.way01;

/**
 * 
 * @author Administrator
 *
 */
public class Test {
	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		Thread t = new Thread(myThread,"Ïß³Ì1");
		t.start();
	}
}
