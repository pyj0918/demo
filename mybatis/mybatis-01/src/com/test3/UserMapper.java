package com.test3;

import org.apache.ibatis.annotations.Insert;

import com.test1.User;

/**
 * ʹ��ע��ķ�ʽ
 * 
 * @author Administrator
 * 
 */
public interface UserMapper {
	@Insert("insert into user (name,age) values (#{name},#{age})")
	public int add(User user);
}
