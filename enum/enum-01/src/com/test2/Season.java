package com.test2;

public enum Season implements IShow {
	Spring("����", "���쿪ʼ��ѿ") {
		public void show() {
			System.out.println("spring show");
		}
	},
	Summer("����", "����̫����") {
		public void show() {
			System.out.println("Summer show");
		}
	},
	Autumn("���", "������Ҷ��") {
		public void show() {
			System.out.println("Autumn show");
		}
	},
	Winter("����", "������ѩ��") {
		public void show() {
			System.out.println("Winter show");
		}
	};

	private String name;
	private String desc;

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

}
