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
			 * ������һ��Ҫ�ǳ�ע�⣬sleep���������ͷ�����Ҳ����˵�����ǰ�̳߳��ж�ĳ���������������sleep������
			 * �����߳��޷������������
			 * 
			 */
			synchronized(object){
				i++;
				System.out.println("i:"+i);
				try {
					System.out.println("�߳�"+Thread.currentThread().getName()+"����˯��״̬");
					Thread.currentThread().sleep(100000);
				} catch (Exception e) {
					
				}
				System.out.println("�߳�"+Thread.currentThread().getName()+"˯�߽���");
				i++;
				System.out.println("i:"+i);
			}
		}
	}
}
