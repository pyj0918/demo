package com.thread17.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Test {
	public static void main(String[] args) {
		ExecutorService es = Executors.newCachedThreadPool();
		//ThreadPoolExecutor executor = new ThreadPoolExecutor();
	}
}
