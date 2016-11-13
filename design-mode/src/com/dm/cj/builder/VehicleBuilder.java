package com.dm.cj.builder;

/**
 * 抽象建造者 具有四种方法 装配框架 装配发动机 装配轮子 装配车门
 * 
 * @author angelo
 * 
 */
public abstract class VehicleBuilder {
	protected Vehicle vehicle;

	public Vehicle getVehicle() {
		return vehicle;
	}
	
	public abstract void buildFrame();//装配框架
	public abstract void buildEngine();//装配发动机
	public abstract void buildWheels();//装配轮子
	public abstract void buildDoors();//装配车门
	
	
}
