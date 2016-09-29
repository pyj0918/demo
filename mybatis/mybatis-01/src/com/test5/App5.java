package com.test5;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.bean.Classes;
import com.util.MyBatisUtil;

public class App5 {
	@Test
	public void test() {
		SqlSession session = MyBatisUtil.getFactory().openSession();
		Classes classes = session
				.selectOne("com.test5.classMapper.getClass2", 2);
		session.close();
		System.out.println(classes);
	}
}
