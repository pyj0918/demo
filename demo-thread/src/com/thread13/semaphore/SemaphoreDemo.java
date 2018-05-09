package com.thread13.semaphore;

import java.util.concurrent.Semaphore;

/**
 * 信号量,允许多个线程同时访问
 */
public class SemaphoreDemo implements Runnable {
	final Semaphore semp = new Semaphore(5);

	public void run() {
		try {
			semp.acquire();
			Thread.sleep(5000);
			System.out.println(Thread.currentThread().getId() + ":done");
			semp.release();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
