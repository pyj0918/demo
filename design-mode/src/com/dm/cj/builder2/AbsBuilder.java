package com.dm.cj.builder2;

//抽象建造者
public abstract class AbsBuilder {
	//装cpu
	public abstract void buildCPU();

	//装主板
	public abstract void buildMainboard();

	//装硬盘
	public abstract void buildHD();

	//返回产品
	public abstract Computer getComputer();

}
