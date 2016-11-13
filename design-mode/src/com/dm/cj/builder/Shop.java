package com.dm.cj.builder;

/**
 * ָ����
 * @author angelo
 *
 */
public class Shop {
	public void Construct(VehicleBuilder vehicleBuilder){
		vehicleBuilder.buildFrame();
		vehicleBuilder.buildEngine();
		vehicleBuilder.buildWheels();
		vehicleBuilder.buildDoors();
	}
}
