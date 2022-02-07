package com.example.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.model.user.User;

@Repository
public class UserDao {
	static List<User> users = new ArrayList<>();
	private int count = 2;

	static {
		users.add(new User(1, "Sudheer", new Date(), "9566169765"));
		users.add(new User(2, "Smith", new Date(), "8987675439"));
	}

	public List<User> getAllUsers() {
		return users;
	}

	public User getUserById(int id) {

		for (User usr : users) {
			if (usr.getId() == id) {
				return usr;
			}
		}
		return null;
	}

	public int addUser(User user) {
		if (user.getId() == null) {
			count++;
		}
		user.setId(count);
		users.add(user);
		return count;
	}

	public void deleteUser(int id) {
		System.out.println("Delete user called");
		Iterator<User> itr = users.iterator();
		while(itr.hasNext()) {
			if (itr.next().getId() == id) {
				itr.remove();
			}
		}
	}

}
