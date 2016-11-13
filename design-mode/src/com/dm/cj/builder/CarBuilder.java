package com.dm.cj.builder;

public class CarBuilder extends VehicleBuilder {

	@Override
	public void buildFrame() {
		vehicle = new Vehicle("½Î³µ");
		vehicle.parts.put("frame","Car Frame");
		
	}

	@Override
	public void buildEngine() {
		vehicle.parts.put("engine","2500 CC");
		
	}

	@Override
	public void buildWheels() {
		vehicle.parts.put("wheels","4");
		
	}

	@Override
	public void buildDoors() {
		vehicle.parts.put("doors","4");
		
	}

}
