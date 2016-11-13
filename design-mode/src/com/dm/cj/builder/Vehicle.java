package com.dm.cj.builder;

import java.util.HashMap;
import java.util.Map;

/**
 * ������Ʒ��
 * 
 * @author angelo
 * 
 */
public class Vehicle {
	private String type;
	public Map<String, String> parts = new HashMap<String, String>();

	public Vehicle(String type) {
		this.type = type;
	}

	public void show() {
		System.out.println("���������ͣ�" + type);
		System.out.println("��ܣ�" + parts.get("frame"));
		System.out.println("��������" + parts.get("engine"));
		System.out.println("��������" + parts.get("wheels"));
		System.out.println("��������" + parts.get("doors"));
	}
}
