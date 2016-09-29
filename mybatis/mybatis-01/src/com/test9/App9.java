package com.test9;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.bean.CUser;
import com.util.MyBatisUtil;

// �������
public class App9 {
	// ����һ������ Ĭ���ǿ����� session����Ļ���
	// ���һ������
	// ��ʽһ��session.clearCache()
	// ��ʽ����ִ��CUD����
	// ��ʽ��������ͬһ��session����
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

	// ���Զ�������
	// ʹ�ö�������ʱ��ʵ�������л�
	// ӳ���ļ�����Ļ���
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
