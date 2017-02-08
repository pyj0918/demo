package com.test2;

public enum Season implements IShow {
	Spring("春天", "春天开始发芽") {
		public void show() {
			System.out.println("spring show");
		}
	},
	Summer("夏天", "夏天太热了") {
		public void show() {
			System.out.println("Summer show");
		}
	},
	Autumn("秋节", "秋天落叶了") {
		public void show() {
			System.out.println("Autumn show");
		}
	},
	Winter("冬季", "冬季下雪了") {
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
