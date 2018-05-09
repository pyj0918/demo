package com.thread10.create;

public class Test2 {
	public static void main(String[] args) {
		Runnable myThread = new MyThread2();
		Thread t = new Thread(myThread,"Ïß³Ì1");
		t.start();
	}
}
