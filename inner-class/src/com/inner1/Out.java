package com.inner1;

/**
 * �����ڲ��� Ӧ�ó����������ó����ڲ���˽�л��������������ط�ʹ��
 * 
 * @author Administrator
 * 
 */
public class Out {
	private int x = 100;

	public void outMethod() {
		x++;
	}

	// �����ڲ���
	// ����private ���������������ط�ʹ��
	class Inner {
		private String y = "hello";

		public void innerMethod() {
			System.out.println("�ڲ����� String =" + y);
			System.out.println("�ⲿ���е�x =" + x);// ֱ�ӷ����ⲿ���е�ʵ������x
			outMethod();
			System.out.println("x is " + Out.this.x);
		}
	}

	public void makeInner() {
		// ���ⲿ�෽���д����ڲ���ʵ��
		Inner in = new Inner();
	}
}
