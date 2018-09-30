package com.dm.cj.builder2;

//具体的建造者:联想电脑
public class LevonBuilder extends AbsBuilder {

	Computer computer = new Computer();

	@Override
	public void buildCPU() {
		computer.setBrandName("联想");
		computer.setCpu("联想CPU");
	}

	@Override
	public void buildMainboard() {
		computer.setMainboard("联想主板");
	}

	@Override
	public void buildHD() {
		computer.setHd("联想硬盘");
	}

	@Override
	public Computer getComputer() {
		return computer;
	}

}
