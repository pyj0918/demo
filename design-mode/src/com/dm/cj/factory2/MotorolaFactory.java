package com.dm.cj.factory2;

/**
 * ������ֻ��������˹���ֻ����Ħ�������ֻ�
 * @author angelo
 *
 */
public class MotorolaFactory implements MobileFactory {

	@Override
	public IMobile createMobile() {
		return new Motorola();
	}

}
