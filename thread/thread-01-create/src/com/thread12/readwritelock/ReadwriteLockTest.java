package com.thread12.readwritelock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 */
public class ReadwriteLockTest {
	private static Lock lock = new ReentrantLock();
	private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	private static Lock readLock = readWriteLock.readLock();
	private static Lock writeLock = readWriteLock.writeLock();
	private int value;

	public Object handleRead(Lock lock) throws InterruptedException {
		try {
			lock.lock();//模拟读操作
			System.out.println("读进来了");
			Thread.sleep(10000);
			return value;
		} finally {
			lock.unlock();
		}
	}

	public void handleWrite(Lock lock, int index) throws InterruptedException {
		try {
			lock.lock();
			System.out.println("写进来了");
			Thread.sleep(10000);//模拟写操作
			value = index;
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		final ReadwriteLockTest demo = new ReadwriteLockTest();
		Runnable readRunnable = new Runnable() {
			@Override
			public void run() {
				try {
					demo.handleRead(readLock);
					//demo.handleRead(lock);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};

		Runnable writeRunnable = new Runnable() {
			@Override
			public void run() {
				try {
					demo.handleWrite(writeLock, new Random().nextInt());
					//demo.handleWrite(lock, new Random().nextInt());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};

		for (int i = 0; i < 18; i++) {
			new Thread(readRunnable).start();
		}

		for (int i = 0; i < 20; i++) {
			new Thread(writeRunnable).start();
		}

	}

}
