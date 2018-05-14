/**
 * 
 */
package com.rdalabs.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * @author Habil Mohammed
 *
 */
@Repository
public class UserDaoService {

	private static List<User> users = new ArrayList<User>();
	
	private static int usersCount = 3;
	
	static {
		users.add(new User(1, "Adam", new Date()));
		users.add(new User(2, "Eve", new Date()));
		users.add(new User(3, "Jack", new Date()));
	}
	
	public List<User> findAll() {
		return users;
	}
	
	public User save(User user) {
		
		if (user.getId() == null) {
			user.setId(++usersCount);
		}
		
		if (users.add(user)) {
			return user;
		} else {
			return null;
		}
		
	}
	
	public User findOne(int id) {
		for (User user: users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
}
