package com.dm.cj.builder;

//���彨���ߣ�Ħ�г�����
public class MotoCycleBuilder extends VehicleBuilder{

	@Override
	public void buildFrame() {
		vehicle = new Vehicle("Ħ�г�");
		vehicle.parts.put("frame","MotoCycle Frame");
		
	}

	@Override
	public void buildEngine() {
		
		vehicle.parts.put("engine","500 CC");
	}

	@Override
	public void buildWheels() {
		vehicle.parts.put("wheels","2");
		
	}

	@Override
	public void buildDoors() {
		vehicle.parts.put("doors","0");
		
	}

}
