package com.dm.cj.builder2;

//¾ßÌåµÄ½¨ÔìÕß£º»İÆÕµçÄÔ
public class HpBuilder extends AbsBuilder {

	Computer computer = new Computer();

	@Override
	public void buildCPU() {
		computer.setBrandName("»İÆÕ");
		computer.setCpu("»İÆÕCPU");
	}

	@Override
	public void buildMainboard() {
		computer.setMainboard("»İÆÕÖ÷°å");

	}

	@Override
	public void buildHD() {
		computer.setHd("»İÆÕÓ²ÅÌ");

	}

	@Override
	public Computer getComputer() {
		return computer;
	}

}
