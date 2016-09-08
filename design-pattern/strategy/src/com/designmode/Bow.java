package com.designmode;

/**
 * 弓(具体的策略类)
 * 
 * @author angelo
 *
 */
public class Bow implements IStrategy {

	@Override
	public void fighting() {
		System.out.println("向敌人放冷箭中......");
	}

}
