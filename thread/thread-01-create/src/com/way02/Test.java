package com.way02;

public class Test {
	public static void main(String[] args) {
		Runnable myThread = new MyThread();
		Thread t = new Thread(myThread,"�߳�1");
		t.start();
	}
}
