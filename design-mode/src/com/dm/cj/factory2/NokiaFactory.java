package com.dm.cj.factory2;

public class NokiaFactory implements MobileFactory{

	@Override
	public IMobile createMobile() {
		return new Nokia();
	}

}
