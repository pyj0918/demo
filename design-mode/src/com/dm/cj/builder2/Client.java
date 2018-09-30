package com.dm.cj.builder2;

//¿Í»§¶Ë
public class Client {
	public static void main(String[] args) {
		Director d = new Director();
		AbsBuilder hp = new HpBuilder();
		AbsBuilder le = new LevonBuilder();
		d.construct(hp);
		d.construct(le);
		Computer com = hp.getComputer();
		com.show();
		com = le.getComputer();
		com.show();
	}
}
