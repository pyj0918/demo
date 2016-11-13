package com.dm.xw.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体被观察者
 * @author angelo
 *
 */
public class Teacher implements Subject{
	
	private String phone;
	private List<Observer> observerList;
	
	public Teacher(){
		observerList = new ArrayList<Observer>();
	}
	
	@Override
	public void registerObserver(Observer observer) {
		observerList.add(observer);
		
	}

	@Override
	public void removeObserver(Observer observer) {
		observerList.remove(observer);
		
	}

	@Override
	public void notifyObserver() {
		for (Observer observer : observerList) {
			//当老师的电话更换后，通知观察者进行更新
			observer.update(phone);
		}
		
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
		//通知所有的观察者
		notifyObserver();
	}

}
