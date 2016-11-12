package com.test;

import java.util.ArrayList;
import java.util.List;

public class Task implements Runnable {

	@Override
	public void run() {
		int i = 0;
		while (true) {
			i++;
			List<User> userList = new ArrayList<User>();
			User user = new User();
			user.setAge(1);
			user.setName("pyj");
			userList.add(user);
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public void test() {
		List<User> userList = new ArrayList<User>();
		User user = new User();
		user.setAge(1);
		user.setName("pyj");
		userList.add(user);
	}
}
