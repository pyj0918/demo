package com.test7;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.bean.ConditionUser;
import com.util.MyBatisUtil;

public class App7 {
	@Test
	public void testname() {
		SqlSession session = MyBatisUtil.getFactory().openSession();
		ConditionUser parameter = new ConditionUser();
		String name = null;
		parameter.setAgeMax(30);
		parameter.setAgeMin(1);
		parameter.setName("%" + name + "%");
		List<Object> list = session.selectList("com.test7.userMapper.getUser",
				parameter);
		session.close();
		System.out.println(list);
	}
}
