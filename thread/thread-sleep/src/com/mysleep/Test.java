package com.mysleep;

public class Test {
	private int i=0;
	private Object object = new Object();
	
	public static void main(String[] args) {
		Test test = new Test();
		MyThread thread1=test.new MyThread();
		MyThread thread2 = test.new MyThread();
		thread1.start();
		thread2.start();
	}
	
	class MyThread extends Thread{
		@Override
		public void run(){
			/**
			 * 但是有一点要非常注意，sleep方法不会释放锁，也就是说如果当前线程持有对某个对象的锁，调用sleep方法，
			 * 其他线程无法访问这个对象
			 * 
			 */
			synchronized(object){
				i++;
				System.out.println("i:"+i);
				try {
					System.out.println("线程"+Thread.currentThread().getName()+"进入睡眠状态");
					Thread.currentThread().sleep(100000);
				} catch (Exception e) {
					
				}
				System.out.println("线程"+Thread.currentThread().getName()+"睡眠结束");
				i++;
				System.out.println("i:"+i);
			}
		}
	}
}
