package com.thread10.create;

public class MyThread2 implements Runnable{

	@Override
	public void run() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("�����̵߳ķ�ʽ����ʵ��Runnable�ӿ�");
		
	}

}
