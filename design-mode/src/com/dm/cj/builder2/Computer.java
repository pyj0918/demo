package com.dm.cj.builder2;

import java.util.ArrayList;
import java.util.List;

//����Ĳ�Ʒ
public class Computer {

	private String brandName;//Ʒ������
	private String model;//�ͺ�
	private String cpu;//cpu
	private String mainboard;//����
	private String hd;//Ӳ��

	public void show() {
		System.out.println("Ʒ������:" + this.brandName);
		System.out.println("�ͺ�:" + this.model);
		System.out.println("cpu:" + this.cpu);
		System.out.println("����:" + this.mainboard);
		System.out.println("Ӳ��:" + this.hd);
		System.out.println(this.brandName + "������װ��ɣ�������");
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
