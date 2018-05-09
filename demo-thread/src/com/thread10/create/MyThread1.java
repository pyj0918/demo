package com.thread10.create;

/**
 * 方式一：继承Thread类
 * @author Administrator
 *
 */
public class MyThread1 extends Thread {

	@Override
	public void run() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("创建线程的方式一：继承Thread类");
	}
	
}
