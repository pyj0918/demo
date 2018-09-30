package com.dm.cj.builder2;

import java.util.ArrayList;
import java.util.List;

//具体的产品
public class Computer {

	private String brandName;//品牌名称
	private String model;//型号
	private String cpu;//cpu
	private String mainboard;//主板
	private String hd;//硬盘

	public void show() {
		System.out.println("品牌名称:" + this.brandName);
		System.out.println("型号:" + this.model);
		System.out.println("cpu:" + this.cpu);
		System.out.println("主板:" + this.mainboard);
		System.out.println("硬盘:" + this.hd);
		System.out.println(this.brandName + "电脑组装完成，请验收");
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMainboard() {
		return mainboard;
	}

	public void setMainboard(String mainboard) {
		this.mainboard = mainboard;
	}

	public String getHd() {
		return hd;
	}

	public void setHd(String hd) {
		this.hd = hd;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

}
