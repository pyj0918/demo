package com.thread14.produceconsume;

/**
 * 生产者消费者问题
 */
public class TestProduceConsume {
	public static void main(String[] args) {
		Clerk clerk = new Clerk();
		Producer p1 = new Producer(clerk);
		Consumer c1 = new Consumer(clerk);

		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(c1);
		Thread t3 = new Thread(p1);

		t1.setName("生产者1");
		t2.setName("消费者1");
		t3.setName("生产者2");

		t1.start();
		t2.start();
		t3.start();
	}
}

// 店员，用于共享数据
class Clerk {
	int product;

	public synchronized void addProduct() {// 生产产品
		if (product >= 20) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			product++;
			System.out.println(Thread.currentThread().getName() + "生产了第"
					+ product + "个产品");
			notifyAll();
		}
	}

	public synchronized void consumeProduct() {// 消费产品
		if (product <= 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println(Thread.currentThread().getName() + "消费了第"
					+ product + "个产品");
			product--;
			notifyAll();// 有多个生产者，唤醒多个
		}
	}
}

// 生产者
class Producer implements Runnable {

	Clerk clerk;

	public Producer(Clerk clerk) {
		this.clerk = clerk;
	}

	@Override
	public void run() {
		System.out.println("生产者开始生产产品");
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

// 消费者
class Consumer implements Runnable {

	Clerk clerk;

	public Consumer(Clerk clerk) {
		this.clerk = clerk;
	}

	@Override
	public void run() {
		System.out.println("消费者开始消费产品");
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

