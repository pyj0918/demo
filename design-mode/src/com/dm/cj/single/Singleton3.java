package com.dm.cj.single;

/**
 * ����ʽ����ģʽ2��Ҫ�õ�ʱ���ȥʵ������ ���̻߳����µĵ���ģʽ
 * 
 * @author angelo
 * 
 */
public class Singleton3 {

	private static volatile Singleton3 instance;

	private Singleton3() {
	}

	/**
	 * ���ﱣֻ֤��ʵ����һ�Σ�Ҳ���ǵ�һ�ν���ʵ�������������������þͲ���ȥʵ����
	 * 
	 * @return
	 */
	public static Singleton3 getInstance() {
		if (instance == null) {
			synchronized (Singleton3.class) {
				//˫�ػ��(ע�⣺��Ҫʹ��volatile�ؼ��ֶ�instance��������)
				//����volatile�ؼ�����Ϊ�˵�instance���º󣬹����ڴ潫���º��ֵ���·������ڴ棬�����������̴߳����ڴ��õ�instanceʱ��֤�����µ�
				//�����ڴ�������ɸ��ٻ���
				if (instance == null) {
					instance = new Singleton3();
				}
			}
		}
		return instance;
	}
}
