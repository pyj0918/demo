package com.inner3;

/**
 * �ֲ��ڲ���
 * 
 * @author Administrator
 * 
 */
public class Out {
	private int size = 5, y = 7;

	public Object makeInner(int localVar) {
		final int finalLocalVar = localVar;
		// �����ֲ��ڲ��࣬����ֻ��makeInner����������Ч������ֲ�����һ�����ڷ������ⲿ���ܴ���MyInner��Ķ���
		class Inner {
			int y = 4;

			public String toString() {
				return "OuterSize:" + size + "\nfinalLocalVar" + " " + "this.y=" + this.y;
			}
		}
		return new Inner();
	}
	
}
