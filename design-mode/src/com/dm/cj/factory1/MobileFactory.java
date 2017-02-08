package com.dm.cj.factory1;

public class MobileFactory {

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
