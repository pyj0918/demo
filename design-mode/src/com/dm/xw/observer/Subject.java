package com.dm.xw.observer;

/**
 * ���۲���
 * @author angelo
 *
 */
public interface Subject {
	//ע��۲���
	void registerObserver(Observer observer);
	//�Ƴ��۲���
	void removeObserver(Observer observer);
	//֪ͨ�۲���
	void notifyObserver();
}
