package com.test2;
/**
 * ʹ��wait,notify,�����ӡ100
 * @author angelo
 *
 */
public class MyMain {
	public static void main(String[] args) {
		PrintNum p = new PrintNum();
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(p);
		t1.setName("��");
		t2.setName("��");

		t1.start();
		t2.start();
	}
}

class PrintNum implements Runnable {
	int num = 1;

	@Override
	public void run() {
		while (true) {
			synchronized (this) {
				notify();
				System.out.println(Thread.currentThread().getName()+"������,�Ҹ������̷߳���֪ͨ");
				if (num <= 100) {
					try {
						Thread.sleep(20000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + ":"
							+ num);
					num++;
				} else {
					break;
				}
				try {
					System.out.println(Thread.currentThread().getName()+"����wait��(�ͷ�����)");
					//���߳�ִ��wait�󣬻�������ȴ��أ������̻߳��õ���������ͬ�������
					wait();
					System.out.println(Thread.currentThread().getName()+"wait��,����");
					System.out.println(Thread.currentThread().getName()+"����ǰ");
					Thread.sleep(30000);
					System.out.println(Thread.currentThread().getName()+"���ߺ�");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}//
			}
		}

	}
}
