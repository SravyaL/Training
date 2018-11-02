package com.springcoredemo.iodemo.ui;

public class UserServiceParamedImpl implements IUserService {
	public UserServiceParamedImpl() {

	}

	public String getWelcomeStatement() {
		return welcomeStatement;
	}

	public void setWelcomeStatement(String welcomeStatement) {
		this.welcomeStatement = welcomeStatement;
	}

	private String welcomeStatement;

	public UserServiceParamedImpl(String welcomeStatement) {
		this.welcomeStatement = welcomeStatement;
	}

	public String welcomeUser(String userName) {
		return welcomeStatement + "!" + userName;
	}

}
