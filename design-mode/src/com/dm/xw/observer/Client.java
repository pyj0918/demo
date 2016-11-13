package com.dm.xw.observer;

public class Client {
	public static void main(String[] args) {
		Teacher zhangsan = new Teacher();
		Student linlei = new Student();
		Student lianjie = new Student();
		Student wangchao = new Student();
		
		zhangsan.registerObserver(linlei);
		zhangsan.registerObserver(lianjie);
		zhangsan.registerObserver(wangchao);
		
		zhangsan.setPhone("13537837675");
		linlei.show();
		lianjie.show();
		wangchao.show();
		
		//电话变更
		zhangsan.setPhone("12345678912");
		linlei.show();
		lianjie.show();
		wangchao.show();
		
		
	}
}
