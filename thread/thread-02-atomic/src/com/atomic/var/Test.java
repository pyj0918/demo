package com.atomic.var;

import java.util.concurrent.atomic.AtomicLong;

public class Test extends Thread {

	private final AtomicLong count = new AtomicLong(0);

	@Override
	public void run() {
		System.out.println(count.incrementAndGet() + "---"+ Thread.currentThread().getName());
	}

	public static void main(String[] args) {
		Test test = new Test();
		Thread t1 = new Thread(test, "t1");
		Thread t2 = new Thread(test, "t2");
		Thread t3 = new Thread(test, "t3");
		Thread t4 = new Thread(test, "t4");
		Thread t5 = new Thread(test, "t5");
		Thread t6 = new Thread(test, "t6");
		Thread t7 = new Thread(test, "t7");
		Thread t8 = new Thread(test, "t8");
		Thread t9 = new Thread(test, "t9");
		Thread t10 = new Thread(test, "t10");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
		t10.start();
	}

}
