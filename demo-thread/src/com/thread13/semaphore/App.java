package com.thread13.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 信号量的使用
 *
 */
public class App {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(20);
		final SemaphoreDemo demo = new SemaphoreDemo();
		for (int i = 0; i < 20; i++) {
			exec.execute(demo);
		}
		//		for(;;){
		//			System.out.println("11");
		//		}
	}
}
