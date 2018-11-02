package com.springcoredemo.iodemo.ui;

public class UserServiceDefaultImpl implements IUserService {
	public String welcomeUser(String userName){
		return "Hello!"+userName;
	}

}
