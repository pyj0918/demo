package com.dm.cj.builder;

/**
 * �������� �������ַ��� װ���� װ�䷢���� װ������ װ�䳵��
 * 
 * @author angelo
 * 
 */
public abstract class VehicleBuilder {
	protected Vehicle vehicle;

	public Vehicle getVehicle() {
		return vehicle;
	}
	
	public abstract void buildFrame();//װ����
	public abstract void buildEngine();//װ�䷢����
	public abstract void buildWheels();//װ������
	public abstract void buildDoors();//װ�䳵��
	
	
}
