package com.test1;

/**
 * 采用类的方式自定义枚举类
 * 
 * @author angelo
 * 
 */
public class Season {
	// 类的成员变量，用final进行修饰，必须在定义时或构造函数中进行初始化赋值
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

	public static final Season Spring = new Season("春天", "春天开始发芽");
	public static final Season Summer = new Season("夏天", "夏天太热了");
	public static final Season Autumn = new Season("秋节", "秋天落叶了");
	public static final Season Winter = new Season("冬季", "冬季下雪了");

}
