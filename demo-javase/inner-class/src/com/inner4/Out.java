package com.inner4;

public class Out {
	/**
	 * 1.�����ڲ�����Լ̳�һ�����ʵ��һ���ӿڣ� �������ڲ��಻��ͬʱʵ��һ���ӿںͼ̳�һ����
	 * ��Ҳ����ʵ�ֶ���ӿڡ����ʵ����һ���ӿڣ�������Object���ֱ�����࣬������̳�һ�����ʵ��һ���ӿ�
	 * ������Ҫextends��implements�ؼ���
	 * 2.���������ڲ���û�����ƣ����������в��ܶ��幹�췽�������ڲ�֪������Ҳ����ʹ�ùؼ��������������ʵ��
	 * ��ʵ���������ڲ���Ķ��塢���졢�͵�һ��ʹ�ö�������ͬ��һ���ط�
	 * 
	 * @return
	 */
	public Object makeInner1() {

		return new Object() {
			public String toString() {
				return "OuterSize=\nfinalLocalVar=";
			}
		};
	}

	public String makeInner2() {
		new My() {

		};
		return null;
	}
}

interface My {

}
