package com.test;

import com.test.TestYield.MyThread;

public class TestYield {

	private int i = 0;
	private Object object = new Object();

	/**
	 * Thread.yield()方法作用是：表示暂停当前线程，执行其他线程(包括自身线程) 由cpu决定
	 * 
	 * yield()应该做的是让当前运行线程回到可运行状态，以允许具有相同优先级的其他线程获得运行机会。因此，使用yield()
	 * 的目的是让相同优先级的线程之间能适当的轮转执行。但是，实际中无法保证yield()达到让步目的，
	 * 因为让步的线程还有可能被线程调度程序再次选中。
	 * 
	 * 
	 * 调用yield方法会让当前线程交出CPU权限，让CPU去执行其他的线程。它跟sleep方法类似，同样不会释放锁。
	 * 但是yield不能控制具体的交出CPU的时间，另外，yield方法只能让拥有相同优先级的线程有获取CPU执行时间的机会。
	 * 注意，调用yield方法并不会让线程进入阻塞状态，而是让线程重回就绪状态，它只需要等待重新获取CPU执行时间， 
	 * 这一点是和sleep方法不一样的。
	 * 
	 * 
	 */
	public static void main(String[] args) {
		TestYield test = new TestYield();
		MyThread thread1 = test.new MyThread();
		MyThread thread2 = test.new MyThread();
		MyThread thread3 = test.new MyThread();
		MyThread thread4 = test.new MyThread();
		MyThread thread5 = test.new MyThread();
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
	}

	class MyThread extends Thread {
		@Override
		public void run() {
			// 如果是线程持有某个对象锁，再调用yield方法，各线程的执行结果会是咋样？
			synchronized (object) {
				i++;
				System.out.println("i:" + i);
				yield();
				System.out.println("线程" + Thread.currentThread().getName()+ "交出cpu权限");
				
				//让线程多执行一段时间，再观察线程的状况
				for(int i=0;i<1000000000;i++){
					int a = i;
					//System.out.println(a);
				}
				System.out.println("i:" + i);
			}
		}
	}

}
