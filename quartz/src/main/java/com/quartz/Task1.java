package com.quartz;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 * 
 */
public class Task1 {

	private static int i = 0;

	public void exec() {
		i++;
		List<User> userList = new ArrayList<User>();
		User user = new User();
		user.setAge(1);
		user.setName("pyj");
		userList.add(user);
		System.out.println(i);
	}
}
