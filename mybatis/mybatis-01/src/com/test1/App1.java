package com.test1;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bean.User;


public class App1 {
	public static void main(String[] args) throws Exception {
		/*String resource = "conf.xml";
		
		// 加载mybatis配置文件(它也加载关联的映射文件)
		//Reader reader = Resources.getResourceAsReader(resource);
		//SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		
		//或
		InputStream is = App1.class.getClassLoader().getResourceAsStream("conf.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()
				.build(is);
		SqlSession session = sessionFactory.openSession();
		String statement = "com.test1.userMapper" + ".getUser";
		User user = session.selectOne(statement, 1);
		System.out.println(user);*/
	}
}
