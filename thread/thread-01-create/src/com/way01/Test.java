package com.way01;

/**
 * 
 * @author Administrator
 *
 */
public class Test {
	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		Thread t = new Thread(myThread,"�߳�1");
		t.start();
	}
}
