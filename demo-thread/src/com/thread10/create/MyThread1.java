package com.thread10.create;

/**
 * ��ʽһ���̳�Thread��
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
		System.out.println("�����̵߳ķ�ʽһ���̳�Thread��");
	}
	
}
