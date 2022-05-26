package com.ty.food.service;

import java.util.List;

import com.ty.food.Util.AES;
import com.ty.food.dao.UserDao;
import com.ty.food.dto.User;



public class UserService {

	UserDao dao = new UserDao();

	public User saveUser(User user) {
		
		String encEmail = AES.encrypt(user.getEmail(), "email") ;
		String encpwd = AES.encrypt(user.getPassword(), "password") ;
		
		user.setEmail(encEmail);
		user.setPassword(encpwd);

		return dao.saveUser(user);
	}

	public User getUSerById(int id) {
		return dao.getUSerById(id);
	}

	public List<User> getAllUser() {
		return dao.getAllUser();
	}

	public User validateUser(String mail, String password) {
		String encEmail = AES.encrypt(mail, "email") ;
		String encpwd = AES.encrypt(password, "password") ;
		
		return dao.validateUser(encEmail, encpwd);
	}

	public boolean deleteUserById(int id) {
		return dao.deleteUserById(id) ;
	}
}
