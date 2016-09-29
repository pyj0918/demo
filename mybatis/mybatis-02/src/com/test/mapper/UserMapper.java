package com.test.mapper;

import java.util.List;

import com.test.entity.User;

public interface UserMapper {
	void save(User user);

	void update(User user);

	void delete(int id);

	User findById(int id);

	List<User> findAll();
	
	
}
