package com.test02.trylock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ÂÖÑ¯ËøÊ¾Àý
 * 
 * @author Administrator
 * 
 */
public class Test {
	private int i;
	Lock lock = new ReentrantLock();

	public static void main(String[] args) {
		Test t = new Test();
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
		while (true) {
			if (lock.tryLock()) {
				try {
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
}
