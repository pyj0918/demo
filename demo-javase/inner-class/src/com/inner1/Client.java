package com.inner1;

public class Client {
	public static void main(String[] args) {
		Out out = new Out();
		//�����ڲ�����Ҫͨ���ⲿ���ʵ�����ܴ���������ʵ��������Ҫͨ����������������
		Out.Inner inner = out.new Inner();
		inner.innerMethod();
	}
}
