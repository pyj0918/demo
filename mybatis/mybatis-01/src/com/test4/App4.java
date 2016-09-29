package com.test4;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.bean.Order;
import com.util.MyBatisUtil;

public class App4 {
	@Test
	public void testSelectOne(){
		SqlSession session = MyBatisUtil.getFactory().openSession();
		Order order = session.selectOne("com.test4.orderMapper.getOrder2",1);
		session.close();
		System.out.println(order);

	}
}
