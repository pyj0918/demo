package com.dm.xw.observer;

/**
 * 被观察者
 * @author angelo
 *
 */
public interface Subject {
	//注册观察者
	void registerObserver(Observer observer);
	//移除观察者
	void removeObserver(Observer observer);
	//通知观察者
	void notifyObserver();
}
