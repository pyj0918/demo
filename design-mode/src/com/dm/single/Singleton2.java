package com.dm.single;

/**
 * ����ʽ����ģʽ1��Ҫ�õ�ʱ���ȥʵ������ �ڵ��߳�����²�������κ����⣬ÿ�η��ض���ͬһ������,���ڶ��߳�����»�����̰߳�ȫ������
 * 
 * @author angelo
 * 
 */
public class Singleton2 {
	// ʹ�þ�̬˽��ȫ�ֱ�������Ψһ��ʵ��
	private static Singleton2 singleton;

	private Singleton2() {
	}

	/**
	 * ���ﱣֻ֤��ʵ����һ�Σ�Ҳ���ǵ�һ�ν���ʵ�������������������þͲ���ȥʵ����
	 * 
	 * @return
	 */
	public static Singleton2 getInstance() {
		if (singleton == null) {
			singleton = new Singleton2();
		}
		return singleton;
	}
}
