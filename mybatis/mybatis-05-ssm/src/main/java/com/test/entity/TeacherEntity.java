package com.test.entity;

public class TeacherEntity {
	private int tId;
	private String tName;
	

	public TeacherEntity() {
		super();
	}

	public TeacherEntity(int tId, String tName) {
		super();
		this.tId = tId;
		this.tName = tName;
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}
	
	

}
