package com.test9;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.bean.CUser;
import com.util.MyBatisUtil;

// 缓存测试
public class App9 {
	// 测试一级缓存 默认是开启的 session级别的缓存
	// 清除一级缓存
	// 方式一：session.clearCache()
	// 方式二：执行CUD操作
	// 方式三：不是同一个session对象
	@Test
	public void test1() {
		SqlSession session = MyBatisUtil.getFactory().openSession();
		CUser user = session.selectOne("com.test9.userMapper.getUser", 1);
		System.out.println(user);

		// session.clearCache();

		// session.update("com.test9.userMapper.updateUser", new CUser(1,
		// "pyj",33));
		// session.commit();
		user = session.selectOne("com.test9.userMapper.getUser", 1);
		System.out.println(user);
		session.close();
	}

	// 测试二级缓存
	// 使用二级缓存时，实体需序列化
	// 映射文件级别的缓存
	@Test
	public void test2() {
		SqlSession session1 = MyBatisUtil.getFactory().openSession();
		SqlSession session2 = MyBatisUtil.getFactory().openSession();
		CUser user = session1.selectOne("com.test9.userMapper.getUser", 1);
		System.out.println(user);
		session1.commit();
		user = session2.selectOne("com.test9.userMapper.getUser", 1);
		System.out.println(user);

	}
}
