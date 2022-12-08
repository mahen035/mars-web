package com.training.web.service;

import java.util.List;

import com.training.web.dao.UserDao;
import com.training.web.model.User;

//Service layer will contain all the business logic
public class UserService {
	
	public boolean isValidUser(String userName, String password) {
		boolean isValid = false;
		UserDao dao = new UserDao();
		List<User> userList = dao.getUserList();
		for(User usr:userList) {
			if(usr.getUserName().equalsIgnoreCase(userName) && usr.getPassword().equalsIgnoreCase(password)) {
				isValid = true;
			}
		}
		return isValid;
	}

}
