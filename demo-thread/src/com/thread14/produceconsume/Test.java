package com.thread14.produceconsume;

/**
 * synchronized修饰方法到底锁住的是什么
 */
public class Test {

	public static void main(String[] args) {

		final MyTest test = new MyTest();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					test.m1();
				}

			}

		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					test.m2();
				}

			}
		});

		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					MyTest.m3();
				}

			}
		});

		t1.start();
		t2.start();
		t3.start();
	}

}

class MyTest {
	public synchronized void m1() {
		try {
			System.out.println("m1被阻塞");
			Thread.sleep(20000);
			System.out.println("m1激活了");
		} catch (Exception e) {

		}
	}

	public synchronized void m2() {
		try {
			System.out.println("m2被阻塞");
			Thread.sleep(40000);
			System.out.println("m2激活了");
		} catch (Exception e) {

		}
	}

	public static synchronized void m3() {
		try {
			System.out.println("m3被阻塞");
			Thread.sleep(40000);
			System.out.println("m3激活了");
		} catch (Exception e) {

		}
	}
}
