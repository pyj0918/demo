package com.demo;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 3773836222329251371L;
	
	public static String userName;
	private transient String password;
	private String age;
	public transient static String title;
	public  String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

}
