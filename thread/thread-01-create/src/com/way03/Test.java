package com.way03;

/**
 * ʹ��������
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
				System.out.println("�����̵߳ķ�ʽ����ʹ��������");
				
			}},"�߳�1");
		t.start();
	}
}
