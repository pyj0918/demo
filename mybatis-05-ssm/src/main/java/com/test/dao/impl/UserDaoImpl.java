package com.test.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.test.dao.IUserDao;
import com.test.entity.UserEntity;

@Repository(value="userDao")
public class UserDaoImpl extends BaseDao implements IUserDao {

	@Override
	public void save(UserEntity entity) {
		try {
			SqlSession session = getSession();
			session.insert("com.test.mapper.UserMapper.save", entity);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
