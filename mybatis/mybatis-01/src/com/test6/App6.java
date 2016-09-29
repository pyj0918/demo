package com.test6;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.bean.Classes;
import com.util.MyBatisUtil;

public class App6 {
	@Test
	public void testname() {
		SqlSession session = MyBatisUtil.getFactory().openSession();
		Classes classes = session.selectOne("com.test6.classMapper.getClass2",2);
		session.close();
		System.out.println(classes);
	}
}
