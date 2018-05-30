package com.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TransientTest {
	public static void main(String[] args) {
		User user = new User();
		user.setUserName("zhangsan");
		user.setPassword("123456");
		user.setAge("35");
		User.title = "title1";

		System.out.println("read before Serializable: ");
		System.out.println("username: " + user.getUserName());
		System.err.println("password: " + user.getPassword());
		System.err.println("title: " + User.title);

		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("e:/user.txt"));
			os.writeObject(user);//将对象写进文件
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			//反序列化之前改变username的值
			User.userName = "lishi";
			User.title = "title2";
			user.setAge("36");
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("e:/user.txt"));
			user = (User) is.readObject(); // 从流中读取User的数据
			is.close();
			System.out.println("\nread after Serializable: ");
			System.out.println("username: " + user.getUserName());
			System.out.println("password: " + user.getPassword());
			System.out.println("age: " + user.getAge());
			System.err.println("title: " + User.title);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
