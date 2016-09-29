package com.test8;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.util.MyBatisUtil;

public class App8 {
	@Test
	public void testname() {
		SqlSession session = MyBatisUtil.getFactory().openSession();
		Map<String, Integer> parameterMap = new HashMap<String, Integer>();
		parameterMap.put("sexValue", 1);
		parameterMap.put("userCount", -1);
		session.selectOne("com.test8.userMapper.getUserCount", parameterMap);
		session.close();
		System.out.println(parameterMap.get("userCount"));
	}
}
