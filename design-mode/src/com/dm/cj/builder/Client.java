package com.dm.cj.builder;

public class Client {
	public static void main(String[] args) {
		// ���쳵�估ָ����
		Shop shop = new Shop();
		VehicleBuilder b2 = new CarBuilder();
		VehicleBuilder b3 = new MotoCycleBuilder();
		//װ�䲢��ʾ����
		shop.Construct(b2);
		b2.vehicle.show();
		
		shop.Construct(b3);
		b3.vehicle.show();
		
	}
}
