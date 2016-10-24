package com.test3;

import java.util.ArrayList;
import java.util.List;

public class Test {
	
	private static String a="111";
	
	static
	{	
		a="2222";
	}
	

	
	

	public static void main(String[] args) {
		List<?> list0=null;
		List<String> strList = new ArrayList<String>();
		List<Integer> intList = new ArrayList<Integer>();
		list0=strList;
		list0=intList;
		
		List<? super OrderEntity> list1 = null;
		List<? extends OrderEntity> list2 = null;
		
		list1 = new ArrayList<ParentOrderEntity>();
		list2 = new ArrayList<SubOrderEntity>();
		
		Test t = new Test();
		System.out.println(t.a);

	}
	
	public <T extends OrderEntity> void get(T t){
		
	}
}

