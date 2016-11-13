package com.dm.xw.observer;

/**
 * 具体观察者
 * 
 * @author angelo
 * 
 */
public class Student implements Observer {

	private String name;
	private String teacherPhone;

	@Override
	public void update(Object obj) {

		this.teacherPhone = (String) obj;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void show() {
		System.out.println("teacher phone is " + teacherPhone);
	}

}
