package com.verizon.iocdemo.service;

public class UserServiceDefaultImpl implements IUserService {

	@Override
	public String welcomeUser(String userName) {
		
		return "Hello! "+ userName;
	}

}
