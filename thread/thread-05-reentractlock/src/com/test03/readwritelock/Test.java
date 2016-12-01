package com.test03.readwritelock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ��д����
 * 
 * ��д���Ŀ�ѡʵ�֣�
 * 
 * 1. �ͷ����ȡ���д�����ͷź�Ӧ������ѡ����̣߳�д�̣߳��������ȷ���������߳�?
 * 
 * 2. ���̲߳�ӡ����ɶ��̳߳��У�д�߳��ٵȴ�������һ�����̣߳��Ǽ����ö��̷߳��ʣ�������д�̷߳���.
 * 
 * 3. �����ԡ���ȡ����д�����Ƿ������?
 * 
 * 4. ��������д��������Ϊ��ȡ����
 * 
 * 5. ����������ȡ������Ϊд������
 * 
 * �����ĳ���ʱ��ϳ����Ҵ󲿷ֲ����������޸ı��ػ�����Դʱ�����ö�д����߲����ԡ�
 * 
 * @author Administrator
 * 
 */
public class Test {
	private final Map<String, String> map = new HashMap<String, String>();
	private final ReadWriteLock lock = new ReentrantReadWriteLock();
	private final Lock r = lock.readLock();
	private final Lock w = lock.writeLock();

	public static void main(String[] args) {

	}

	public void put(String key, String value) {
		w.lock();// ����д��
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
