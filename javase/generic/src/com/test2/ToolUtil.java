package com.test2;

public class ToolUtil {
	/**
	 * ´ø·µ»ØÖµ
	 * 
	 * @param t
	 * @return
	 */
	public <T> int get1(T t) {
		System.out.println(t.getClass().getName());
		return 2;
	}

	public <T> void get2(T t) {
		System.out.println(t.getClass().getName());
	}

	public static <T, V> void get3(T t, V v) {
		System.out.println(t.getClass().getName());
	}
}
