package com.dm.cj.factory2;

/**
 * 具体的手机工厂，此工厂只生产摩托罗拉手机
 * @author angelo
 *
 */
public class MotorolaFactory implements MobileFactory {

	@Override
	public IMobile createMobile() {
		return new Motorola();
	}

}
