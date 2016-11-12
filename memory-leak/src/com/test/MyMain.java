package com.test;

import java.util.HashMap;
import java.util.Map;

public class MyMain {
	public static void main(String[] args) {
		Runnable r = new Task();
		Thread t = new Thread(r,"");
		t.start();
	}

	public static void sleep(long sleepFor) {
		try {
			Thread.sleep(sleepFor);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// get available memory in MB
	public static long getFreeMemory() {
		return Runtime.getRuntime().freeMemory() / (1024 * 1024);
	}
}

class Key {
	private String key;

	public Key(String key) {
		super();
		this.key = key;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof Key)
			return key.equals(((Key) obj).key);
		else
			return false;

	}

	@Override
	public int hashCode() {
		return key.hashCode();
	}

}
