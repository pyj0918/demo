package com.dm.cj.factory2;

/**
 * 具体的手机工厂，此工厂只生产诺基亚手机
 * @author angelo
 *
 */
public class NokiaFactory implements MobileFactory{

	@Override
	public IMobile createMobile() {
		return new Nokia();
	}

}
