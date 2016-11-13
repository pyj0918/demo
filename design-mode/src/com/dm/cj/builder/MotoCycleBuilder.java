package com.dm.cj.builder;

//具体建造者：摩托车车间
public class MotoCycleBuilder extends VehicleBuilder{

	@Override
	public void buildFrame() {
		vehicle = new Vehicle("摩托车");
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
