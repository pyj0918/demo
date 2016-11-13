package com.dm.cj.builder;

import java.util.HashMap;
import java.util.Map;

/**
 * 车辆产品类
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
		System.out.println("车辆类类型：" + type);
		System.out.println("框架：" + parts.get("frame"));
		System.out.println("发动机：" + parts.get("engine"));
		System.out.println("轮子数：" + parts.get("wheels"));
		System.out.println("车门数：" + parts.get("doors"));
	}
}
