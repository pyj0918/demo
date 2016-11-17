package com.test2;
/**
 * 使用wait,notify,交替打印100
 * @author angelo
 *
 */
public class MyMain {
	public static void main(String[] args) {
		PrintNum p = new PrintNum();
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(p);
		t1.setName("甲");
		t2.setName("乙");

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
				System.out.println(Thread.currentThread().getName()+"进来了,且给其它线程发了通知");
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
					System.out.println(Thread.currentThread().getName()+"进入wait了(释放了锁)");
					//当线程执行wait后，会进入对象等待池，其它线程会拿到锁，进入同步代码块
					wait();
					System.out.println(Thread.currentThread().getName()+"wait后,醒了");
					System.out.println(Thread.currentThread().getName()+"休眠前");
					Thread.sleep(30000);
					System.out.println(Thread.currentThread().getName()+"休眠后");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}//
			}
		}

	}
}
