package com.dm.cj.builder2;

//ָ����
public class Director {
	public void construct(AbsBuilder builder) {
		builder.buildCPU();
		builder.buildMainboard();
		builder.buildHD();
	}
}
