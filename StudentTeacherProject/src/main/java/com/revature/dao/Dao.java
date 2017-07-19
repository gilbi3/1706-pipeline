package com.revature.dao;

import com.revature.beans.User;

public interface Dao {

	public User getUser(User user);
	
	public void createUser(User user);
}
