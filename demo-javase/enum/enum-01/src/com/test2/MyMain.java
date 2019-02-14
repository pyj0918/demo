package com.test2;

public class MyMain {
	public static void main(String[] args) {
		Season season = Season.Summer;
		
		System.out.println(season.getName()+"-----"+season.getDesc());
		season.show();
	}
}
