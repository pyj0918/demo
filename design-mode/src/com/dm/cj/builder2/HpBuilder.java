package com.dm.cj.builder2;

//����Ľ����ߣ����յ���
public class HpBuilder extends AbsBuilder {

	Computer computer = new Computer();

	@Override
	public void buildCPU() {
		computer.setBrandName("����");
		computer.setCpu("����CPU");
	}

	@Override
	public void buildMainboard() {
		computer.setMainboard("��������");

	}

	@Override
	public void buildHD() {
		computer.setHd("����Ӳ��");

	}

	@Override
	public Computer getComputer() {
		return computer;
	}

}
