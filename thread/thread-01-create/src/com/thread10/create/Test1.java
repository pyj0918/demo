package com.thread10.create;

/**
 * 
 * @author Administrator
 *
 */
public class Test1 {
	public static void main(String[] args) {
		MyThread1 myThread = new MyThread1();
		Thread t = new Thread(myThread,"Ïß³Ì1");
		t.start();
	}
}
