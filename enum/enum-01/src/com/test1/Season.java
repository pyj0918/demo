package com.test1;

/**
 * ������ķ�ʽ�Զ���ö����
 * 
 * @author angelo
 * 
 */
public class Season {
	// ��ĳ�Ա��������final�������Σ������ڶ���ʱ���캯���н��г�ʼ����ֵ
	private final String name;
	private final String desc;

	private Season(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}

	public String getName() {
		return name;
	}

	public String getDesc() {
		return desc;
	}

	public static final Season Spring = new Season("����", "���쿪ʼ��ѿ");
	public static final Season Summer = new Season("����", "����̫����");
	public static final Season Autumn = new Season("���", "������Ҷ��");
	public static final Season Winter = new Season("����", "������ѩ��");

}
