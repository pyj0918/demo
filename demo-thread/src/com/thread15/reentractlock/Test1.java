package com.thread15.reentractlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test1 {

	private int i;
	Lock lock = new ReentrantLock();

	public static void main(String[] args) {
		Test1 t = new Test1();
		t.task();
	}

	public void task() {
		Thread t1 = new Thread() {
			@Override
			public void run() {
				getResult();
			}
		};

		Thread t2 = new Thread() {
			@Override
			public void run() {
				getResult();
			}
		};

		t1.start();
		t2.start();
	}

	public void getResult() {
		// lock的标准写法
		while (true) {
			try {
				lock.lock();
				//lock.lockInterruptibly();
				i++;
				System.out.println(i);
				Thread.sleep(200);
			} catch (Exception e) {

			} finally {
				lock.unlock();
			}
		}
	}
}
