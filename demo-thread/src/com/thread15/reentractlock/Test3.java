package com.thread15.reentractlock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁：
 * 
 * 读写锁的可选实现：
 * 
 * 1. 释放优先。当写入锁释放后，应该优先选择读线程，写线程，还是最先发出请求的线程?
 * 
 * 2. 读线程插队。锁由读线程持有，写线程再等待，再来一个读线程，是继续让读线程访问，还是让写线程访问.
 * 
 * 3. 重入性。读取锁和写入锁是否可重入?
 * 
 * 4. 降级。将写入锁降级为读取锁。
 * 
 * 5. 升级。将读取锁升级为写入锁。
 * 
 * 当锁的持有时间较长并且大部分操作都不会修改被守护的资源时，可用读写锁提高并发性。
 * 
 * @author Administrator
 * 
 */
public class Test3 {
	private final Map<String, String> map = new HashMap<String, String>();
	private final ReadWriteLock lock = new ReentrantReadWriteLock();
	private final Lock r = lock.readLock();
	private final Lock w = lock.writeLock();

	public static void main(String[] args) {

	}

	public void put(String key, String value) {
		w.lock();// 请求写锁
		try {
			map.put(key, value);
		} catch (Exception e) {

		} finally {
			w.unlock();
		}
	}

	public String get(String key) {
		r.lock();
		try {
			return map.get(key);
		} finally {
			r.unlock();
		}
	}
}

