package com.thread15.reentractlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 轮询锁示例
 */
public class Test2 {
	private int i;
	Lock lock = new ReentrantLock();

	public static void main(String[] args) {
		Test2 t = new Test2();
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
