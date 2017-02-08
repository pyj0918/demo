package com.dm.cj.factory2;

public class MotorolaFactory implements MobileFactory {

	@Override
	public IMobile createMobile() {
		return new Motorola();
	}

}
