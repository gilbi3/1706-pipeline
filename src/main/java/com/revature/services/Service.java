package com.revature.services;

import com.revature.beans.User;
import com.revature.dao.DaoImpl;

public class Service {
	
	public User loginUser(User user) {
		DaoImpl imp = new DaoImpl();
		User storedUser = imp.getUser(user);
		if (storedUser.getUsername().equals(user.getUsername()) &&
			storedUser.getPw().equals(user.getPw())){
			return storedUser;
		}
		return null;
	}

	
	public static void registerUser(User user) {
		DaoImpl imp = new DaoImpl();
		imp.createUser(user);
	}
}
