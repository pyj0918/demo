package com.designmode;

/**
 * 定义环境类(武士)
 * 
 * @author angelo
 *
 */
public class Wusi {
	private IStrategy strategy;

	public Wusi(IStrategy strategy) {
		this.strategy = strategy;
	}

	public void fighting() {
		this.strategy.fighting();
	}
}
