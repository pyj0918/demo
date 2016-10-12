package com.way02;

public class Test {
	public static void main(String[] args) {
		Runnable myThread = new MyThread();
		Thread t = new Thread(myThread,"Ïß³Ì1");
		t.start();
	}
}
