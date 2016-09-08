package com.designmode;

/**
 * 加农炮(具体的策略类)
 * 
 * @author angelo
 *
 */
public class Cannon implements IStrategy {

	@Override
	public void fighting() {
		System.out.println("轰击敌人中......");
	}

}
