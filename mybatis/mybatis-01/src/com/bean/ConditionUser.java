package com.bean;

/**
 * 查询条件的封装
 * 
 * @author Administrator
 * 
 */
public class ConditionUser {
	private String name;
	private int ageMax;
	private int ageMin;

	@Override
	public String toString() {
		return "ConditionUser [name=" + name + ", ageMax=" + ageMax
				+ ", ageMin=" + ageMin + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAgeMax() {
		return ageMax;
	}

	public void setAgeMax(int ageMax) {
		this.ageMax = ageMax;
	}

	public int getAgeMin() {
		return ageMin;
	}

	public void setAgeMin(int ageMin) {
		this.ageMin = ageMin;
	}

}
