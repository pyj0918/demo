package com.test3;

import org.apache.ibatis.annotations.Insert;

import com.test1.User;

/**
 * 使用注解的方式
 * 
 * @author Administrator
 * 
 */
public interface UserMapper {
	@Insert("insert into user (name,age) values (#{name},#{age})")
	public int add(User user);
}
