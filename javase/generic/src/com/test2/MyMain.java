package com.test2;

import com.test1.OrderEntity;

public class MyMain {
	public static void main(String[] args) {
		
		ToolUtil util = new ToolUtil();
		//System.out.println(util.get1(4));
		util.get3(new OrderEntity(),"33");
	}
}
