package com.dm.cj.factory1;

public class MobileFactory {
	// 通过传入参数来确定返回哪种产品
	public IMobile getMobile(String title) {
		if (title.equalsIgnoreCase("nokia")) {
			return new Nokia();
		} else if (title.equalsIgnoreCase("motorola")) {
			return new Motorola();
		} else {
			throw new RuntimeException("not found mobile");
		}
	}
}
