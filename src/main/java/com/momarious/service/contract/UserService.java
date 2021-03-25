package com.momarious.service.contract;

import java.util.List;

import com.momarious.model.User;

public interface UserService {

	User findByUsername(String findLoggedInUsername);

	List<User> findAll();

	User findById(Integer id);

	void save(User user);

	void deleteById(Integer id);
	
	void edit(User user);

	String getPasswordById(Integer id);

}
