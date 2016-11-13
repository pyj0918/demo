package com.dm.xw.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * ���屻�۲���
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
			//����ʦ�ĵ绰������֪ͨ�۲��߽��и���
			observer.update(phone);
		}
		
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
		//֪ͨ���еĹ۲���
		notifyObserver();
	}

}
