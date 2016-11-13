package com.dm.cj.builder;

public class Client {
	public static void main(String[] args) {
		// 创造车间及指挥者
		Shop shop = new Shop();
		VehicleBuilder b2 = new CarBuilder();
		VehicleBuilder b3 = new MotoCycleBuilder();
		//装配并显示车辆
		shop.Construct(b2);
		b2.vehicle.show();
		
		shop.Construct(b3);
		b3.vehicle.show();
		
	}
}
