package com.dm.cj.factory2;

/**
 * ������ֻ��������˹���ֻ����ŵ�����ֻ�
 * @author angelo
 *
 */
public class NokiaFactory implements MobileFactory{

	@Override
	public IMobile createMobile() {
		return new Nokia();
	}

}
