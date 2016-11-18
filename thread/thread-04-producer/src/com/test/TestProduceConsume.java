package com.test;

/**
 * ����������������
 * 
 * @author angelo
 * 
 */
public class TestProduceConsume {
	public static void main(String[] args) {
		Clerk clerk = new Clerk();
		Producer p1 = new Producer(clerk);
		Consumer c1 = new Consumer(clerk);

		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(c1);
		Thread t3 = new Thread(p1);

		t1.setName("������1");
		t2.setName("������1");
		t3.setName("������2");

		t1.start();
		t2.start();
		t3.start();
	}
}

// ��Ա�����ڹ�������
class Clerk {
	int product;

	public synchronized void addProduct() {// ������Ʒ
		if (product >= 20) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			product++;
			System.out.println(Thread.currentThread().getName() + "�����˵�"
					+ product + "����Ʒ");
			notifyAll();
		}
	}

	public synchronized void consumeProduct() {// ���Ѳ�Ʒ
		if (product <= 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println(Thread.currentThread().getName() + "�����˵�"
					+ product + "����Ʒ");
			product--;
			notifyAll();// �ж�������ߣ����Ѷ��
		}
	}
}

// ������
class Producer implements Runnable {

	Clerk clerk;

	public Producer(Clerk clerk) {
		this.clerk = clerk;
	}

	@Override
	public void run() {
		System.out.println("�����߿�ʼ������Ʒ");
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			clerk.addProduct();
		}

	}
}

// ������
class Consumer implements Runnable {

	Clerk clerk;

	public Consumer(Clerk clerk) {
		this.clerk = clerk;
	}

	@Override
	public void run() {
		System.out.println("�����߿�ʼ���Ѳ�Ʒ");
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			clerk.consumeProduct();
		}

	}

}
