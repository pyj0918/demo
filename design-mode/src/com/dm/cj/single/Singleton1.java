package com.dm.cj.single;


/**
 * 
 * ����ʽ ����ʽ��Ȼ����˶��߳���������Ӱ�죬���Ǹö�����������ص�ʱ��ͷŵ��ڴ档����ö����㹻��ռ����Դ�϶࣬�Ʊػ�Ӱ����������
 * 
 * @author angelo
 * 
 */
public class Singleton1 {
	// ʹ�þ�̬˽��ȫ�ֱ�������Ψһ��ʵ��
	private static Singleton1 singleton = new Singleton1();

	private Singleton1() {
	}

	/**
	 * ���ﱣֻ֤��ʵ����һ�Σ�Ҳ���ǵ�һ�ν���ʵ�������������������þͲ���ȥʵ����
	 * 
	 * @return
	 */
	public static Singleton1 getInstance() {
		return singleton;
	}
}
