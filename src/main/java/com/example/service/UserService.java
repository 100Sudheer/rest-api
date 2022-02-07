package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dao.UserDao;
import com.example.model.user.User;

@Component
public class UserService {

	@Autowired
	UserDao userDao;

	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	public User getUserById(int id) {
		return userDao.getUserById(id);
	}

	public int addUser(User user) {
		return userDao.addUser(user);
	}

	public void deleteUser(int id) {
		userDao.deleteUser(id);
	}
}
