package com.way03;

/**
 * 使用匿名类
 * @author Administrator
 *
 */
public class Test {
	public static void main(String[] args) {
		Thread t = new Thread(new Runnable(){
			@Override
			public void run() {
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("创建线程的方式三：使用匿名类");
				
			}},"线程1");
		t.start();
	}
}
