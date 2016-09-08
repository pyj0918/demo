package com.designmode;

/**
 * 刀(具体的策略类)
 * 
 * @author angelo
 *
 */
public class Knife implements IStrategy {

	@Override
	public void fighting() {
		System.out.println("把敌人千刀万剐中......");
	}

}
