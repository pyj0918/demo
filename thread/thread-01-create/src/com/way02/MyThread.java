package com.way02;

public class MyThread implements Runnable{

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
