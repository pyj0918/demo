package com.test;

import com.test.TestYield.MyThread;

public class TestYield {

	private int i = 0;
	private Object object = new Object();

	/**
	 * Thread.yield()���������ǣ���ʾ��ͣ��ǰ�̣߳�ִ�������߳�(���������߳�) ��cpu����
	 * 
	 * yield()Ӧ���������õ�ǰ�����̻߳ص�������״̬�������������ͬ���ȼ��������̻߳�����л��ᡣ��ˣ�ʹ��yield()
	 * ��Ŀ��������ͬ���ȼ����߳�֮�����ʵ�����תִ�С����ǣ�ʵ�����޷���֤yield()�ﵽ�ò�Ŀ�ģ�
	 * ��Ϊ�ò����̻߳��п��ܱ��̵߳��ȳ����ٴ�ѡ�С�
	 * 
	 * 
	 * ����yield�������õ�ǰ�߳̽���CPUȨ�ޣ���CPUȥִ���������̡߳�����sleep�������ƣ�ͬ�������ͷ�����
	 * ����yield���ܿ��ƾ���Ľ���CPU��ʱ�䣬���⣬yield����ֻ����ӵ����ͬ���ȼ����߳��л�ȡCPUִ��ʱ��Ļ��ᡣ
	 * ע�⣬����yield�������������߳̽�������״̬���������߳��ػؾ���״̬����ֻ��Ҫ�ȴ����»�ȡCPUִ��ʱ�䣬 
	 * ��һ���Ǻ�sleep������һ���ġ�
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
			// ������̳߳���ĳ�����������ٵ���yield���������̵߳�ִ�н������զ����
			synchronized (object) {
				i++;
				System.out.println("i:" + i);
				yield();
				System.out.println("�߳�" + Thread.currentThread().getName()+ "����cpuȨ��");
				
				//���̶߳�ִ��һ��ʱ�䣬�ٹ۲��̵߳�״��
				for(int i=0;i<1000000000;i++){
					int a = i;
					//System.out.println(a);
				}
				System.out.println("i:" + i);
			}
		}
	}

}
