package com.springcoredemo.iodemo.ui;

import java.util.Set;

public class UserServiceMultipleImpl implements IUserService {
	private Set<String> welcomeStatements;
	public UserServiceMultipleImpl(){}
	
	
	public String welcomeUser(String userName) {
		
		Set<String> welcomeStatements;
		return userName;
		
	}


	public Set<String> getWelcomeStatements() {
		return welcomeStatements;
	}


	public void setWelcomeStatements(Set<String> welcomeStatements) {
		this.welcomeStatements = welcomeStatements;
	}

}
