package com.thread10.create;

public class Test2 {
	public static void main(String[] args) {
		Runnable myThread = new MyThread2();
		Thread t = new Thread(myThread,"�߳�1");
		t.start();
	}
}
