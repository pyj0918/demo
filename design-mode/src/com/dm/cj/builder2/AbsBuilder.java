package com.dm.cj.builder2;

//��������
public abstract class AbsBuilder {
	//װcpu
	public abstract void buildCPU();

	//װ����
	public abstract void buildMainboard();

	//װӲ��
	public abstract void buildHD();

	//���ز�Ʒ
	public abstract Computer getComputer();

}
